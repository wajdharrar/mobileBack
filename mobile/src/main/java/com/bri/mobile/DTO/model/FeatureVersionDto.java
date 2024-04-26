package com.bri.mobile.DTO.model;

import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class FeatureVersionDto {
    private FeatureVersionIdDto idFeatureVersion;
    private String value;
}
