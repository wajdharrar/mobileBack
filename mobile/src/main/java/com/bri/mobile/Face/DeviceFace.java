package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.DTO.model.DeviceTypeDto;

import java.util.List;

public interface DeviceFace {
    public List<DeviceDto> getAllDevices();
    public DeviceDto getDeviceById(int id);
    public DeviceDto addDevice(DeviceDto device);
    public DeviceDto updateDevice(DeviceDto device, int id);
    public void deleteDevice(int id);
    public List<DeviceDto>getAllDevicesByDeviceType(DeviceTypeDto deviceTypeDto);
    public DeviceDto updateState(int id, DeviceDto device);

    }
