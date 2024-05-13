package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.CartMap;
import com.bri.mobile.DTO.model.CartDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Face.CartFace;
import com.bri.mobile.Repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements CartFace {
    @Autowired
    CartRepo cartRepo;
    @Override
    public List<CartDto> addToCart(List<CartDto> items) {
        return CartMap.toCartListDto(cartRepo.saveAll(CartMap.toCartListEntity(items)));
    }
    @Override
    public List<CartDto> getByIdRequest(Request request){
        return CartMap.toCartListDto(cartRepo.findByRequest(request));
    }
    @Override
    public void deleteCart(List<CartDto> items){
        cartRepo.deleteAll(CartMap.toCartListEntity(items));
    }
}
