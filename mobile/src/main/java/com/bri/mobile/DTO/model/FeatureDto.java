package com.bri.mobile.DTO.model;

import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDto {
    private int idFeature;
    private String nameFeature;
}
