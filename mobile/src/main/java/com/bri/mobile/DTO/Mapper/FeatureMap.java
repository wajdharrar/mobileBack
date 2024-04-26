package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.FeatureDto;

import com.bri.mobile.Entity.Feature;

import java.util.List;
import java.util.stream.Collectors;

public class FeatureMap {
    public static FeatureDto toFeatureDto(Feature feature){
        return FeatureDto.builder()
                .idFeature(feature.getIdFeature())
                .nameFeature(feature.getNameFeature())
                .build();
    }
    public static Feature toFeatureEntity(FeatureDto featureDto){
        return Feature.builder()
                .idFeature(featureDto.getIdFeature())
                .nameFeature(featureDto.getNameFeature())
                .build();
    }
    public static List<FeatureDto> toFeatureListDto(List<Feature> features ){
        return features.stream()
                .map(device ->toFeatureDto(device))
                .collect(Collectors.toList());
    }
    public static List<Feature> toFeatureListEntity(List<FeatureDto> featureDtos ){
        return featureDtos.stream()
                .map(phoneDto ->toFeatureEntity(phoneDto))
                .collect(Collectors.toList());
    }
}
