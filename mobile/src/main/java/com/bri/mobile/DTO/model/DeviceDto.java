package com.bri.mobile.DTO.model;


import com.bri.mobile.Enum.State;
import lombok.*;


@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto{
        private int idDevice;
        private String nameDevice;
        private float price;
        private int inventory;
        private String imgDevice;
        private String descDevice;
        private String color;
        private int warranty;
        private State state;
        private String reason;
        private SaleDto sale;
        private VersionDto version;
        private DeviceTypeDto deviceType;
}
