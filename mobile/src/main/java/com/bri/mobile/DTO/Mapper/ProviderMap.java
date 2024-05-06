package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.ProviderDto;
import com.bri.mobile.Entity.Provider;

public class ProviderMap {
    public static ProviderDto toProviderdto (Provider provider){
        return ProviderDto.builder()
                .idProvider(provider.getIdProvider())
                .nameRes(provider.getNameRes())
                .lastNameRes(provider.getLastNameRes())
                .emailRes(provider.getEmailRes())
                .numberRes(provider.getNumberRes())
                .idUser(provider.getIdUser())
                .build();
    }
    public static Provider toProviderEntity(ProviderDto providerDto){
        return Provider.builder()
                .idProvider(providerDto.getIdProvider())
                .nameRes(providerDto.getNameRes())
                .lastNameRes(providerDto.getLastNameRes())
                .emailRes(providerDto.getEmailRes())
                .numberRes(providerDto.getNumberRes())
                .idUser(providerDto.getIdUser())
                .build();
    }
}
