package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.DTO.model.ProviderDeviceDto;

import java.util.List;

public interface ProviderDeviceFace {
   ProviderDeviceDto addProviderDevice(ProviderDeviceDto providerDeviceDto);
   public List<ProviderDeviceDto> getAllProviderDevice( );
   List <DeviceDto>findTop8ByOrderByCreatedAtDesc();
}
