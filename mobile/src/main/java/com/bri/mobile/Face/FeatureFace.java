package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.FeatureDto;
import com.bri.mobile.Entity.Feature;
import com.bri.mobile.Entity.User;

import java.util.List;

public interface FeatureFace {
    List<FeatureDto> getAllFeatures();
    List<FeatureDto> getFeaturesByDeviceType(int idDeviceType);
    List<FeatureDto> getByVersionId(int idVersion);
    FeatureDto getFeatureById(int id);
    FeatureDto addFeature(FeatureDto feature);
    FeatureDto updateFeature(FeatureDto feature, int id);
    void deleteFeature(int id);
}
