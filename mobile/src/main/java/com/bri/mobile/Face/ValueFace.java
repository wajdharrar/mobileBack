package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.FeatureDto;
import com.bri.mobile.DTO.model.ValueDto;


import java.util.List;

public interface ValueFace {
    List<ValueDto> getAllValues();
    ValueDto getValueById(int id);
    ValueDto addValue(ValueDto value);
    ValueDto updateValue(ValueDto value, int id);
    void deleteValue(int id);
    List<ValueDto>getValueByFeature(FeatureDto feature);
}
