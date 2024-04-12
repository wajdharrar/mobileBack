package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.Entity.DeviceType;
import com.bri.mobile.DTO.model.*;

public class DeviceTypeMap {
    public static DeviceTypeDto toDeviceTypeDto(DeviceType deviceType){
        return DeviceTypeDto.builder()
                .idType(deviceType.getIdType())
                .nameType(deviceType.getNameType())
                .devices(DeviceMap.toDeviceListDto(deviceType.getDevices()))
                .build();

    }
    public static DeviceType toDeviceTypeEntity(DeviceTypeDto deviceTypeDto){
        return DeviceType.builder()
                .idType(deviceTypeDto.getIdType())
                .nameType(deviceTypeDto.getNameType())
                .devices(DeviceMap.toDeviceListEntity(deviceTypeDto.getDevices()))
                .build();

    }
}
