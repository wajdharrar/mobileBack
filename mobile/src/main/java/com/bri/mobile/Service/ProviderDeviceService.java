package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.ProviderDeviceMap;
import com.bri.mobile.DTO.model.ProviderDeviceDto;
import com.bri.mobile.Face.ProviderDeviceFace;
import com.bri.mobile.Repo.ProviderDeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
}
