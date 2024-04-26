package com.bri.mobile.DTO.model;


import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class ValueDto {
    private int idValue;
    private String value;
    private String unit;
    private FeatureDto feature;
}
