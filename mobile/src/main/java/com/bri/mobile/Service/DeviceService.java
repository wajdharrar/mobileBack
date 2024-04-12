package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.DeviceMap;
import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.Entity.Device;
import com.bri.mobile.Face.DeviceFace;
import com.bri.mobile.Repo.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceService implements DeviceFace {
    @Autowired
    DeviceRepo deviceRepo;
    public List<DeviceDto> getAllDevices(){
        List<Device>deviceList=deviceRepo.findAll() ;
        return DeviceMap.toDeviceListDto(deviceList);
    }
    public DeviceDto getDeviceById(int id){return null ;}
    public DeviceDto addPhone(DeviceDto device){return null ;}
    public DeviceDto updatePhone(DeviceDto device, int id){return null ;}
    public void deleteDevice(int id){}
}
