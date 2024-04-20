package com.bri.mobile.DTO.model;


import com.bri.mobile.Enum.State;
import lombok.*;


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
}
