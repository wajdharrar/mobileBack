package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.DeviceMap;
import com.bri.mobile.DTO.Mapper.DeviceTypeMap;
import com.bri.mobile.DTO.Mapper.SaleMap;
import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.Entity.Device;
import com.bri.mobile.Face.DeviceFace;
import com.bri.mobile.Repo.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public DeviceDto addPhone(DeviceDto device){
        return DeviceMap.toDeviceDto(deviceRepo.save(DeviceMap.toDeviceEntity(device)));
    }
    public DeviceDto updatePhone(DeviceDto device, int id){
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
            return DeviceMap.toDeviceDto(oldDevice);
        }else{
            throw new RuntimeException("Device Not Found");
        }
    }
    public void deleteDevice(int id){deviceRepo.deleteById(id);}
}
