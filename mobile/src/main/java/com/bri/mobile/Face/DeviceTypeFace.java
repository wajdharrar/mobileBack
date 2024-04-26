package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.DeviceTypeDto;



import java.util.List;

public interface DeviceTypeFace {
    List<DeviceTypeDto> getAllDeviceTypes();
    DeviceTypeDto getById(int id);

}
