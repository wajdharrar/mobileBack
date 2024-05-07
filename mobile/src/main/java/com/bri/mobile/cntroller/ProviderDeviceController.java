package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.ProviderDeviceDto;
import com.bri.mobile.Face.ProviderDeviceFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providerdevice")
public class ProviderDeviceController {
    @Autowired
    ProviderDeviceFace providerDeviceFace;
    @PostMapping("/add")
    ProviderDeviceDto addProviderDevice(@RequestBody ProviderDeviceDto providerDeviceDto){
        return providerDeviceFace.addProviderDevice(providerDeviceDto);
    }
    @GetMapping("/all")
    List<ProviderDeviceDto> getAll(){
        return providerDeviceFace.getAllProviderDevice();
    }
}
