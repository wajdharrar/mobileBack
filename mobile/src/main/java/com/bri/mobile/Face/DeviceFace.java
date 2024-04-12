package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.DeviceDto;

import java.util.List;

public interface DeviceFace {
    public List<DeviceDto> getAllDevices();
    public DeviceDto getDeviceById(int id);
    public DeviceDto addPhone(DeviceDto device);
    public DeviceDto updatePhone(DeviceDto device, int id);
    public void deleteDevice(int id);
}
