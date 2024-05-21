package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.CartMap;
import com.bri.mobile.DTO.model.CartDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Face.CartFace;
import com.bri.mobile.Repo.CartRepo;
import com.bri.mobile.tool.stat.TopDevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<TopDevices> findTopRequestedDevicesForCurrentWeek(){
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = today.with(DayOfWeek.SUNDAY);
        LocalDateTime startTime= startOfWeek.atTime(1,0);
        LocalDateTime endTime=endOfWeek.atTime(1,0);
        Timestamp startTimestamp = Timestamp.valueOf(startTime);
        Timestamp endTimestamp = Timestamp.valueOf(endTime);
        PageRequest pageRequest=PageRequest.of(0,5);
        List<Object[]> topDevices= cartRepo.findTopRequestedDevicesForCurrentWeek(startTimestamp,endTimestamp,pageRequest);
        return topDevices.stream()
                .map(objects -> new TopDevices((Integer) objects[0],(String)objects[1],(Long) objects[2]))
                .collect(Collectors.toList());
    }
}
