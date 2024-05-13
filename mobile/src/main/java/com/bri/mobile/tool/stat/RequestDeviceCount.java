package com.bri.mobile.tool.stat;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class RequestDeviceCount {
    private String device;
    private Long deviceCount;
}
