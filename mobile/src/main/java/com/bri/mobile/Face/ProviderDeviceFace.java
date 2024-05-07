package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.ProviderDeviceDto;

import java.util.List;

public interface ProviderDeviceFace {
   ProviderDeviceDto addProviderDevice(ProviderDeviceDto providerDeviceDto);
   public List<ProviderDeviceDto> getAllProviderDevice( );
}
