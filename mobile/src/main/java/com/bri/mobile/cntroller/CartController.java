package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.CartDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Face.CartFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartFace cartFace;
    @PostMapping("/add")
    List<CartDto> addToCart(@RequestBody List<CartDto> items){
        return cartFace.addToCart(items);
    }
    @PostMapping("/request")
    List<CartDto> getByIdRequest(@RequestBody Request request){
        return cartFace.getByIdRequest(request);
    }
    @PostMapping("/delete")
    void deleteCart(@RequestBody List<CartDto> items){
        cartFace.deleteCart(items);
    }
}
