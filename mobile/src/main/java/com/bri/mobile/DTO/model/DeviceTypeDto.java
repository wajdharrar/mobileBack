package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.DeviceType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class DeviceTypeDto {
    private int idType;
    private String nameType;
    private List<DeviceDto> devices;
}
