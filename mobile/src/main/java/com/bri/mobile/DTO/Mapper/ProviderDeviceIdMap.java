package com.bri.mobile.DTO.Mapper;


import com.bri.mobile.DTO.model.ProviderDeviceIdDto;


import com.bri.mobile.Entity.ProviderDeviceId;

public class ProviderDeviceIdMap {
    public static ProviderDeviceIdDto toProviderDeviceIdDto(ProviderDeviceId providerDeviceId){
        return ProviderDeviceIdDto.builder()
                .idDevice(providerDeviceId.getIdDevice())
                .idProvider(providerDeviceId.getIdProvider())
                .build();
    }
    public static ProviderDeviceId toProviderDeviceIdEntity(ProviderDeviceIdDto providerDeviceIdDto){
        return ProviderDeviceId.builder()
                .idDevice(providerDeviceIdDto.getIdDevice())
                .idProvider(providerDeviceIdDto.getIdProvider())
                .build();
    }
}
