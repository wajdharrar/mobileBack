package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.Version;
import com.bri.mobile.Enum.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto {
    private int idBrand;
    private String nameBrand;
    private String logoBrand;
    private String descBrand;
    private State state;
    private String reason;
    private List<DeviceDto> devices;
    private List <ModelDto> models;
}
