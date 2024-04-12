package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.GiftPhoneDto;
import com.bri.mobile.DTO.model.GiftPhoneIdDto;
import com.bri.mobile.Entity.GiftPhone;
import com.bri.mobile.Entity.GiftPhoneId;

public class GiftPhoneIdMap {
    public static GiftPhoneIdDto toGiftPhoneIdDto(GiftPhoneId giftPhoneId){
        return GiftPhoneIdDto.builder()
                .idGift(giftPhoneId.getIdGift())
                .idPhone(giftPhoneId.getIdPhone())
                .build();
    }
    public static GiftPhoneId toGiftPhoneEntity(GiftPhoneIdDto giftPhoneIdDto){
        return GiftPhoneId.builder()
                .idGift(giftPhoneIdDto.getIdGift())
                .idPhone(giftPhoneIdDto.getIdPhone())
                .build();
    }
}
