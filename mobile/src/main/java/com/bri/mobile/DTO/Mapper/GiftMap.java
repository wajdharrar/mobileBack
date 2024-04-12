package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.GiftDto;
import com.bri.mobile.DTO.model.ModelDto;
import com.bri.mobile.Entity.Gift;
import com.bri.mobile.Entity.Model;

import java.util.List;
import java.util.stream.Collectors;

public class GiftMap {
    public static GiftDto toGiftDto(Gift gift){
        return GiftDto.builder()
                .idGift(gift.getIdGift())
                .nameGift(gift.getNameGift())
                .imgGift(gift.getImgGift())
                .devices(DeviceMap.toDeviceListDto(gift.getDevices()))
                .state(gift.getState())
                .reason(gift.getReason())
                .build();
    }
    public static Gift toGiftEntity(GiftDto giftDto){
        return Gift.builder()
                .idGift(giftDto.getIdGift())
                .nameGift(giftDto.getNameGift())
                .imgGift(giftDto.getImgGift())
                .devices(DeviceMap.toDeviceListEntity(giftDto.getDevices()))
                .state(giftDto.getState())
                .reason(giftDto.getReason())
                .build();
    }
    public static List<GiftDto> toGiftListDto(List<Gift> gifts){
        return gifts.stream()
                .map(gift ->toGiftDto(gift))
                .collect(Collectors.toList());
    }
    public static List<Gift> toGiftListEntity(List<GiftDto> giftsDto ){
        return giftsDto.stream()
                .map(giftDto ->toGiftEntity(giftDto))
                .collect(Collectors.toList());
    }
}
