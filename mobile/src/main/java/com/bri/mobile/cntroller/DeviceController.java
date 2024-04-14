package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.Face.DeviceFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceFace deviceFace;
    @GetMapping("/all")
    List<DeviceDto>getAll(){
        return deviceFace.getAllDevices();
    }
}
