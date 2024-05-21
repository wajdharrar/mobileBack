package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.DeviceMap;
import com.bri.mobile.DTO.Mapper.DeviceTypeMap;
import com.bri.mobile.DTO.Mapper.SaleMap;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.DTO.model.DeviceTypeDto;

import com.bri.mobile.Entity.Device;

import com.bri.mobile.Enum.State;
import com.bri.mobile.Face.DeviceFace;
import com.bri.mobile.Repo.DeviceRepo;
import com.bri.mobile.tool.stat.DeviceAttributeCount;
import com.bri.mobile.tool.stat.EntityStateCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService implements DeviceFace {
    @Autowired
    DeviceRepo deviceRepo;
    public List<DeviceDto> getAllDevices(){
        List<Device>deviceList=deviceRepo.findAll() ;
        return DeviceMap.toDeviceListDto(deviceList);
    }
    public DeviceDto getDeviceById(int id){
        Optional<Device>deviceTest= deviceRepo.findById(id);
        if(deviceTest.isPresent()){
            return DeviceMap.toDeviceDto(deviceTest.get());
        }else{
            throw new RuntimeException("Device Not Found");
        }
    }
    public DeviceDto addDevice(DeviceDto device){
        return DeviceMap.toDeviceDto(deviceRepo.save(DeviceMap.toDeviceEntity(device)));
    }
    public DeviceDto updateDevice(DeviceDto device, int id){
        Optional<Device>deviceTest= deviceRepo.findById(id);
        if(deviceTest.isPresent()){
            Device oldDevice = deviceTest.get();
            oldDevice.setImgDevice(device.getImgDevice());
            oldDevice.setDescDevice(device.getDescDevice());
            oldDevice.setNameDevice(device.getNameDevice());
            oldDevice.setColor(device.getColor());
            oldDevice.setInventory(device.getInventory());
            oldDevice.setDeviceType(DeviceTypeMap.toDeviceTypeEntity(device.getDeviceType()));
            oldDevice.setWarranty(device.getWarranty());
            oldDevice.setPrice(device.getPrice());
            oldDevice.setSale(SaleMap.toSaleEntity(device.getSale()));
            oldDevice.setState(device.getState());
            return DeviceMap.toDeviceDto(deviceRepo.save(oldDevice));
        }else{
            throw new RuntimeException("Device Not Found");
        }
    }
    public void deleteDevice(int id){deviceRepo.deleteById(id);}
    public List<DeviceDto>getAllDevicesByDeviceType(DeviceTypeDto deviceTypeDto){
        return DeviceMap.toDeviceListDto(deviceRepo.findByDeviceType(DeviceTypeMap.toDeviceTypeEntity(deviceTypeDto)));
    }
    public DeviceDto updateState(int id, DeviceDto device){
        Optional<Device> testDevice=deviceRepo.findById(id);
        if(testDevice.isPresent()){
            Device oldDeviceEntity=testDevice.get();
            DeviceDto oldDeviceDto= DeviceMap.toDeviceDto(oldDeviceEntity);
            oldDeviceDto.setState(device.getState());
            Device deviceToSave = DeviceMap.toDeviceEntity(oldDeviceDto);
            Device deviceRes =deviceRepo.save(deviceToSave);
            return DeviceMap.toDeviceDto(deviceRes);
        }else{
            throw new RuntimeException("device not found");
        }
    }
    public List<EntityStateCount>countDevicesByState(Long id){
        List<Object[]>deviceCount=deviceRepo.countDevicesByState(id);
        return deviceCount.stream()
                .map(objects -> new EntityStateCount((State) objects[0],(Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<DeviceAttributeCount>countDevicesByBrand(Long id){
        List<Object[]> brandCount=deviceRepo.countDevicesByBrand(id);
        return brandCount.stream()
                .map(objects -> new DeviceAttributeCount((String) objects[0],(Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<DeviceAttributeCount>countDevicesByModel(Long id){
        List<Object[]> modelCount=deviceRepo.countDevicesByModel(id);
        return modelCount.stream()
                .map(objects -> new DeviceAttributeCount((String) objects[0],(Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<DeviceAttributeCount> countDevicesByDeviceType(Long id){
        List<Object[]> deviceTypeCount=deviceRepo.countDevicesByDeviceType(id);
        return deviceTypeCount.stream()
                .map(objects -> new DeviceAttributeCount((String) objects[0],(Long)objects[1]))
                .collect(Collectors.toList());
    }

}
