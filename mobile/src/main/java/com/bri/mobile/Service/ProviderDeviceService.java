package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.DeviceMap;
import com.bri.mobile.DTO.Mapper.ProviderDeviceMap;
import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.DTO.model.ProviderDeviceDto;
import com.bri.mobile.Face.ProviderDeviceFace;
import com.bri.mobile.Repo.ProviderDeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderDeviceService implements ProviderDeviceFace {
    @Autowired
    ProviderDeviceRepo providerDeviceRepo;
    @Override
    public ProviderDeviceDto addProviderDevice(ProviderDeviceDto providerDeviceDto){
        return ProviderDeviceMap.toProviderDeviceDto(providerDeviceRepo.save(ProviderDeviceMap.toProviderDeviceEntity(providerDeviceDto)));
    }
    @Override
    public List<ProviderDeviceDto> getAllProviderDevice(){
        return ProviderDeviceMap.toProviderDeviceListDto(providerDeviceRepo.findAll());
    }
    @Override
    public List <DeviceDto>findTop8ByOrderByCreatedAtDesc(){
        PageRequest pageRequest= PageRequest.of(0,8);
        return DeviceMap.toDeviceListDto(providerDeviceRepo.findTop8DevicesOrderByCreatedAtDesc(pageRequest));
    }
}
