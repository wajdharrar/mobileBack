package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.FeatureVersionIdDto;

import com.bri.mobile.Entity.FeatureVersionId;


public class FeatureVersionIdMap {
    public static FeatureVersionIdDto toFeatureVersionIdDto(FeatureVersionId featureVersionId){
        return FeatureVersionIdDto.builder()
                .idFeature(featureVersionId.getIdFeature())
                .idVersion(featureVersionId.getIdVersion())
                .build();
    }
    public static FeatureVersionId toFeatureVersionIdEntity(FeatureVersionIdDto featureVersionIdDto){
        return FeatureVersionId.builder()
                .idFeature(featureVersionIdDto.getIdFeature())
                .idVersion(featureVersionIdDto.getIdVersion())
                .build();
    }
}
