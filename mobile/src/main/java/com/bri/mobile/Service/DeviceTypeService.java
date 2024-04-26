package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.DeviceTypeMap;
import com.bri.mobile.DTO.model.DeviceTypeDto;
import com.bri.mobile.Entity.DeviceType;
import com.bri.mobile.Face.DeviceTypeFace;
import com.bri.mobile.Repo.DeviceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceTypeService implements DeviceTypeFace {
    @Autowired
    DeviceTypeRepo deviceTypeRepo;
    @Override
    public List<DeviceTypeDto> getAllDeviceTypes(){
        return DeviceTypeMap.toDeviceTypeListDto(deviceTypeRepo.findAll());
    }
    @Override
    public DeviceTypeDto getById(int id){
        Optional<DeviceType> testDeviceType=deviceTypeRepo.findById(id);
        if(testDeviceType.isPresent()) {
            return DeviceTypeMap.toDeviceTypeDto(testDeviceType.get());
        }else{
            throw new RuntimeException("device type not Found");
        }
    }
}
