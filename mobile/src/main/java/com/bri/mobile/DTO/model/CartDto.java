package com.bri.mobile.DTO.model;


import com.bri.mobile.Entity.Request;
import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private int idCart;
    private float total;
    private int itemNumber;
    private RequestDto request;
    private DeviceDto device;
}