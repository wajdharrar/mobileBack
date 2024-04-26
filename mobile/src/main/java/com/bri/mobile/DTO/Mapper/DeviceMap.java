package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.Entity.Device;


import java.util.List;
import java.util.stream.Collectors;

public class DeviceMap {
    public static DeviceDto toDeviceDto (Device device){
        return DeviceDto.builder()
                .idDevice(device.getIdDevice())
                .nameDevice(device.getNameDevice())
                .imgDevice(device.getImgDevice())
                .descDevice(device.getDescDevice())
                .color(device.getColor())
                .price(device.getPrice())
                .inventory(device.getInventory())
                .version(VersionMap.toVersionDto(device.getVersion()))
                .warranty(device.getWarranty())
                .sale(SaleMap.toSaleDto(device.getSale()))
                .state(device.getState())
                .reason(device.getReason())
                .deviceType(DeviceTypeMap.toDeviceTypeDto(device.getDeviceType()))
                .build();
    }
    public static Device toDeviceEntity (DeviceDto deviceDto){
        return Device.builder()
                .idDevice(deviceDto.getIdDevice())
                .nameDevice(deviceDto.getNameDevice())
                .imgDevice(deviceDto.getImgDevice())
                .descDevice(deviceDto.getDescDevice())
                .color(deviceDto.getColor())
                .price(deviceDto.getPrice())
                .inventory(deviceDto.getInventory())
                .version(VersionMap.toVersionEntity(deviceDto.getVersion()))
                .warranty(deviceDto.getWarranty())
                .sale(SaleMap.toSaleEntity(deviceDto.getSale()))
                .state(deviceDto.getState())
                .reason(deviceDto.getReason())
                .deviceType(DeviceTypeMap.toDeviceTypeEntity(deviceDto.getDeviceType()))
                .build();
    }
    public static List<DeviceDto> toDeviceListDto(List<Device> devices ){
        return devices.stream()
                .map(device ->toDeviceDto(device))
                .collect(Collectors.toList());
    }
    public static List<Device> toDeviceListEntity(List<DeviceDto> devicesDto ){
        return devicesDto.stream()
                .map(phoneDto ->toDeviceEntity(phoneDto))
                .collect(Collectors.toList());
    }
}
