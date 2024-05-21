package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.DTO.model.DeviceTypeDto;
import com.bri.mobile.Face.DeviceFace;
import com.bri.mobile.tool.stat.DeviceAttributeCount;
import com.bri.mobile.tool.stat.EntityStateCount;
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
    @GetMapping("/count/state/{id}")
    List<EntityStateCount>countDevicesByState(@PathVariable Long id){
        return deviceFace.countDevicesByState(id);
    }
    @GetMapping("/count/brand/{id}")
    List<DeviceAttributeCount>countDevicesByBrand(@PathVariable Long id){
        return deviceFace.countDevicesByBrand(id);
    }
    @GetMapping("/count/model/{id}")
    List<DeviceAttributeCount>countDevicesByModel(@PathVariable Long id){
        return deviceFace.countDevicesByModel(id);
    }
    @GetMapping("/count/device/{id}")
    List<DeviceAttributeCount>countDevicesByDeviceType(@PathVariable Long id){
        return deviceFace.countDevicesByDeviceType(id);
    }

}
