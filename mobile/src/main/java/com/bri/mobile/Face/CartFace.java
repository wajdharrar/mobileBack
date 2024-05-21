package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.CartDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.tool.stat.TopDevices;

import java.util.List;

public interface CartFace {
    List<CartDto> addToCart(List<CartDto> items);
    List<CartDto> getByIdRequest(Request request);
    void deleteCart(List <CartDto> items);
    List<TopDevices> findTopRequestedDevicesForCurrentWeek();
}
