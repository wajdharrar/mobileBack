package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.Feature;
import com.bri.mobile.Enum.State;
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
