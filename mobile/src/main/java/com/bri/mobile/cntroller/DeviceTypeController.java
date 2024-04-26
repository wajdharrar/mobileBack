package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.DeviceTypeDto;
import com.bri.mobile.Face.DeviceTypeFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {
    @Autowired
    DeviceTypeFace deviceTypeFace;
    @GetMapping("/all")
    public List<DeviceTypeDto> getAllDeviceTypes(){
        return deviceTypeFace.getAllDeviceTypes();
    }
    @GetMapping("/{id}")
    public  DeviceTypeDto getById(@PathVariable int id){
        return deviceTypeFace.getById(id);
    }
}
