package com.bri.mobile.DTO.model;

import com.bri.mobile.Enum.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {
    private int idSale;
    private float value;
    private String startDate;
    private String endDate;
    private State state;
    private String reason;
    private List<DeviceDto> devices;
}
