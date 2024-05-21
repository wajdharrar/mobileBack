package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {
    @Autowired
    RecommendationService recommendationService;
    @PostMapping("/devices")
    public List<DeviceDto> recommendDevicesForUser(@RequestBody User user){
        return recommendationService.recommendDevicesForUser(user);
    }
}
