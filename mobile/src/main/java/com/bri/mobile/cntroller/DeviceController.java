package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.DTO.model.DeviceTypeDto;
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
        return deviceFace.addDevice(deviceDto);
    }
    @PostMapping("/device")
    List<DeviceDto> getAllDevicesByDeviceType(@RequestBody DeviceTypeDto deviceTypeDto){
        return deviceFace.getAllDevicesByDeviceType(deviceTypeDto);
    }
    @PutMapping("/updatestate/{id}")
    DeviceDto updateState(@RequestBody DeviceDto deviceDto,@PathVariable int id){
        return deviceFace.updateState(id,deviceDto);
    }
    @DeleteMapping("/delete/{id}")
    void deleteDevice(@PathVariable int id){
        deviceFace.deleteDevice(id);
    }
}
