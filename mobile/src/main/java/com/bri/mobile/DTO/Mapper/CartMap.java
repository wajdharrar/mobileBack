package com.bri.mobile.DTO.Mapper;


import com.bri.mobile.DTO.model.CartDto;
import com.bri.mobile.Entity.Cart;

public class CartMap {
    public static CartDto toCartDto(Cart cart){
        return CartDto.builder()
                .idCart(UserPhoneIdMap.toUserPhoneIdDto(cart.getIdCart()))
                .total(cart.getTotal())
                .itemNumber(cart.getItemNumber())
                .build();
    }
    public static Cart toCartEntity(CartDto cartDto){
        return Cart.builder()
                .idCart(UserPhoneIdMap.toUserPhoneIdEntity(cartDto.getIdCart()))
                .total(cartDto.getTotal())
                .itemNumber(cartDto.getItemNumber())
                .build();
    }
}
