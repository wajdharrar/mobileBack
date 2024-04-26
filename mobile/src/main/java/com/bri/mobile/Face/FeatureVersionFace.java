package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.FeatureVersionDto;
import com.bri.mobile.tool.FeatureValue;


import java.util.List;
import java.util.Map;

public interface FeatureVersionFace {
    List<FeatureVersionDto> addFeaturesToVersion(List<FeatureValue> values, int idVersion);
}
