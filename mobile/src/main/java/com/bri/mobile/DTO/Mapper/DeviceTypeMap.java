package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.Entity.Device;
import com.bri.mobile.Entity.DeviceType;
import com.bri.mobile.DTO.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class DeviceTypeMap {
    public static DeviceTypeDto toDeviceTypeDto(DeviceType deviceType){
        return DeviceTypeDto.builder()
                .idType(deviceType.getIdType())
                .nameType(deviceType.getNameType())
                .build();

    }
    public static DeviceType toDeviceTypeEntity(DeviceTypeDto deviceTypeDto){
        return DeviceType.builder()
                .idType(deviceTypeDto.getIdType())
                .nameType(deviceTypeDto.getNameType())
                .build();

    }
    public static List<DeviceTypeDto> toDeviceTypeListDto(List<DeviceType> deviceTypes ){
        return deviceTypes.stream()
                .map(device ->toDeviceTypeDto(device))
                .collect(Collectors.toList());
    }
    public static List<DeviceType> toDeviceTypeListEntity(List<DeviceTypeDto> deviceTypesDto ){
        return deviceTypesDto.stream()
                .map(phoneDto ->toDeviceTypeEntity(phoneDto))
                .collect(Collectors.toList());
    }
}
