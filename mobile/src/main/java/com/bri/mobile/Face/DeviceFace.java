package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.DTO.model.DeviceTypeDto;
import com.bri.mobile.tool.stat.DeviceAttributeCount;
import com.bri.mobile.tool.stat.EntityStateCount;

import java.util.List;

public interface DeviceFace {
    public List<DeviceDto> getAllDevices();
    public DeviceDto getDeviceById(int id);
    public DeviceDto addDevice(DeviceDto device);
    public DeviceDto updateDevice(DeviceDto device, int id);
    public void deleteDevice(int id);
    public List<DeviceDto>getAllDevicesByDeviceType(DeviceTypeDto deviceTypeDto);
    public DeviceDto updateState(int id, DeviceDto device);
    List<EntityStateCount>countDevicesByState(Long id);
    List<DeviceAttributeCount>countDevicesByBrand(Long id);
    List<DeviceAttributeCount>countDevicesByModel(Long id);
    List<DeviceAttributeCount> countDevicesByDeviceType(Long id);


}
