package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.ModelDto;
import com.bri.mobile.DTO.model.ShopDto;
import com.bri.mobile.Entity.Model;
import com.bri.mobile.Entity.Shop;

import java.util.List;
import java.util.stream.Collectors;

public class ShopMap {
    public static ShopDto toShopDto(Shop shop){
        return ShopDto.builder()
                .idShop(shop.getIdShop())
                .fax(shop.getFax())
                .email(shop.getEmail())
                .address(shop.getAddress())
                .number(shop.getNumber())
                .facebook(shop.getFacebook())
                .instagram(shop.getInstagram())
                .provider(ProviderMap.toProviderdto(shop.getProvider()))
                .build();
    }
    public static Shop toShopEntity(ShopDto shopDto){
        return Shop.builder()
                .idShop(shopDto.getIdShop())
                .fax(shopDto.getFax())
                .email(shopDto.getEmail())
                .address(shopDto.getAddress())
                .number(shopDto.getNumber())
                .facebook(shopDto.getFacebook())
                .instagram(shopDto.getInstagram())
                .provider(ProviderMap.toProviderEntity(shopDto.getProvider()))
                .build();
    }
    public static List<ShopDto> toShopListDto(List<Shop> shops){
        return shops.stream()
                .map(shop ->toShopDto(shop))
                .collect(Collectors.toList());
    }
    public static List<Shop> toShopListEntity(List<ShopDto> shopDtos ){
        return shopDtos.stream()
                .map(shopDto ->toShopEntity(shopDto))
                .collect(Collectors.toList());
    }
}
