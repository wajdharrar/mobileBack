package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.GiftDto;
import com.bri.mobile.DTO.model.GiftPhoneDto;
import com.bri.mobile.Entity.Gift;
import com.bri.mobile.Entity.GiftPhone;

public class GiftPhoneMap {
    public static GiftPhoneDto toGiftPhoneDto(GiftPhone giftPhone){
        return GiftPhoneDto.builder()
                .idGifitPhone(giftPhone.getIdGifitPhone())
                .build();
    }
    public static GiftPhone toGiftPhoneEntity(GiftPhoneDto giftPhoneDto){
        return GiftPhone.builder()
                .idGifitPhone(giftPhoneDto.getIdGifitPhone())
                .build();
    }
}
