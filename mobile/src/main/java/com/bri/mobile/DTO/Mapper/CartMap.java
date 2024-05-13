package com.bri.mobile.DTO.Mapper;


import com.bri.mobile.DTO.model.CartDto;
import com.bri.mobile.DTO.model.RoleDto;
import com.bri.mobile.Entity.Cart;
import com.bri.mobile.Entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class CartMap {
    public static CartDto toCartDto(Cart cart){
        return CartDto.builder()
                .idCart(cart.getIdCart())
                .total(cart.getTotal())
                .itemNumber(cart.getItemNumber())
                .request(RequestMap.toRequestDto(cart.getRequest()))
                .device(DeviceMap.toDeviceDto(cart.getDevice()))
                .build();
    }
    public static Cart toCartEntity(CartDto cartDto){
        return Cart.builder()
                .idCart(cartDto.getIdCart())
                .total(cartDto.getTotal())
                .itemNumber(cartDto.getItemNumber())
                .request(RequestMap.toRequestEntity(cartDto.getRequest()))
                .device(DeviceMap.toDeviceEntity(cartDto.getDevice()))
                .build();
    }
    public static List<CartDto> toCartListDto(List<Cart> carts){
        return carts.stream()
                .map(cart ->toCartDto(cart))
                .collect(Collectors.toList());
    }
    public static List<Cart> toCartListEntity(List<CartDto> cartDtos ){
        return cartDtos.stream()
                .map(cartDto ->toCartEntity(cartDto))
                .collect(Collectors.toList());
    }
}