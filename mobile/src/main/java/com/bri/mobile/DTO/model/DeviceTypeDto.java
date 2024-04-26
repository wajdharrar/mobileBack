package com.bri.mobile.DTO.model;

import lombok.*;



@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class DeviceTypeDto {
    private int idType;
    private String nameType;
}
