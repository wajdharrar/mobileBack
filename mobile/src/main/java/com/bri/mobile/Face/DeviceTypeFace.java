package com.bri.mobile.Face;

import com.bri.mobile.Entity.DeviceType;
import com.bri.mobile.Entity.User;

import java.util.List;

public interface DeviceTypeFace {
    List<DeviceType> getAllDeviceTypes();
    DeviceType getDeviceTypeById(int id);
    DeviceType addDeviceType(DeviceType deviceType);
    DeviceType updateDeviceType(DeviceType deviceType, int id);
    void deleteDeviceType(int id);
}
