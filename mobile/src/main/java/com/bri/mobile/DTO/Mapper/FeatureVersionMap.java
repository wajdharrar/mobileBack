package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.FeatureVersionDto;
import com.bri.mobile.DTO.model.GiftPhoneDto;
import com.bri.mobile.Entity.FeatureVersion;
import com.bri.mobile.Entity.GiftPhone;

public class FeatureVersionMap {
    public static FeatureVersionDto toFeatureVersionDto(FeatureVersion featureVersion){
        return FeatureVersionDto.builder()
                .idFeatureVersion(FeatureVersionIdMap.toFeatureVersionIdDto(featureVersion.getIdFeatureVersion()))
                .value(featureVersion.getValue())
                .build();
    }
    public static FeatureVersion toFeatureVersionEntity(FeatureVersionDto featureVersionDto){
        return FeatureVersion.builder()
                .idFeatureVersion(FeatureVersionIdMap.toFeatureVersionIdEntity(featureVersionDto.getIdFeatureVersion()))
                .value(featureVersionDto.getValue())
                .build();
    }
}
