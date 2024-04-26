package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.Face.DeviceFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    DeviceDto getById(@PathVariable int id){
        return deviceFace.getDeviceById(id);
    }
    @PostMapping("/add")
    DeviceDto addDevice(@RequestBody DeviceDto deviceDto){
        System.out.println(deviceDto.getDeviceType().getIdType());
        return deviceFace.addPhone(deviceDto);
    }
    @PutMapping("/update/{id}")
    DeviceDto updateDevice(@RequestBody DeviceDto deviceDto,@PathVariable int id){
        return deviceFace.updatePhone(deviceDto,id);
    }
    @DeleteMapping("/delete/{id}")
    void deleteDevice(@PathVariable int id){
        deviceFace.deleteDevice(id);
    }
}
