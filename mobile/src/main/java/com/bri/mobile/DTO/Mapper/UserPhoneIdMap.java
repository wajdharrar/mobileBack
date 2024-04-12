package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.UserPhoneIdDto;
import com.bri.mobile.Entity.UserPhoneId;

public class UserPhoneIdMap {
    public static UserPhoneIdDto toUserPhoneIdDto(UserPhoneId userPhoneId){
        return UserPhoneIdDto.builder()
                .idPhone(userPhoneId.getIdPhone())
                .idUser(userPhoneId.getIdUser())
                .build();
    }
    public static UserPhoneId toUserPhoneIdEntity(UserPhoneIdDto userPhoneIdDto){
        return UserPhoneId.builder()
                .idPhone(userPhoneIdDto.getIdPhone())
                .idUser(userPhoneIdDto.getIdUser())
                .build();
    }
}
