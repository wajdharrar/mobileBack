package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.FeatureVersionDto;
import com.bri.mobile.tool.FeatureValue;


import java.util.List;


public interface FeatureVersionFace {
    List<FeatureVersionDto> addFeaturesToVersion(List<FeatureValue> values, int idVersion);
    List<FeatureVersionDto> getAllFeaturesByIdVersion(int idVersion);
}
