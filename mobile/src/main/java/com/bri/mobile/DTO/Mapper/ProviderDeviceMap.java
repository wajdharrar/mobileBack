package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.ProviderDeviceDto;

import com.bri.mobile.Entity.ProviderDevice;


import java.util.List;
import java.util.stream.Collectors;

public class ProviderDeviceMap {
    public static ProviderDeviceDto toProviderDeviceDto(ProviderDevice providerDevice){
        return ProviderDeviceDto.builder()
                .id(ProviderDeviceIdMap.toProviderDeviceIdDto(providerDevice.getId()))
                .build();
    }
    public static ProviderDevice toProviderDeviceEntity(ProviderDeviceDto providerDeviceDto){
        return ProviderDevice.builder()
                .id(ProviderDeviceIdMap.toProviderDeviceIdEntity(providerDeviceDto.getId()))
                .build();
    }
    public static List<ProviderDeviceDto> toProviderDeviceListDto(List<ProviderDevice> providerDevices){
        return providerDevices.stream()
                .map(providerDevice ->toProviderDeviceDto(providerDevice))
                .collect(Collectors.toList());
    }
    public static List<ProviderDevice> toProviderDeviceListEntity(List<ProviderDeviceDto> providerDeviceDtos ){
        return providerDeviceDtos.stream()
                .map(providerDeviceDto ->toProviderDeviceEntity(providerDeviceDto))
                .collect(Collectors.toList());
    }
}
