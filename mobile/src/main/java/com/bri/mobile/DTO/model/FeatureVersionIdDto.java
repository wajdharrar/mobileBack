package com.bri.mobile.DTO.model;

import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class FeatureVersionIdDto {
    private int idFeature;
    private int idVersion;
}
