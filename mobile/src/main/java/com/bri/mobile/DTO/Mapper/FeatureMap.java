package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.FeatureDto;
import com.bri.mobile.Entity.Feature;

public class FeatureMap {
    public static FeatureDto toFeatureDto(Feature feature){
        return FeatureDto.builder()
                .idFeature(feature.getIdFeature())
                .nameFeature(feature.getNameFeature())
                .values(ValueMap.toValueListDto(feature.getValues()))
                .versions(VersionMap.toVersionListDto(feature.getVersions()))
                .build();
    }
    public static Feature toFeatureEntity(FeatureDto featureDto){
        return Feature.builder()
                .idFeature(featureDto.getIdFeature())
                .nameFeature(featureDto.getNameFeature())
                .values(ValueMap.toValueListEntity(featureDto.getValues()))
                .versions(VersionMap.toVersionListEntity(featureDto.getVersions()))
                .build();
    }
}
