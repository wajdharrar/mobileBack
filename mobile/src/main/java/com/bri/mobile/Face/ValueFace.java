package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.FeatureDto;
import com.bri.mobile.DTO.model.ValueDto;
import com.bri.mobile.Entity.Feature;
import com.bri.mobile.Entity.UserPhoneId;
import com.bri.mobile.Entity.Value;

import java.util.List;

public interface ValueFace {
    List<ValueDto> getAllValues();
    ValueDto getValueById(int id);
    ValueDto addValue(ValueDto value);
    ValueDto updateValue(ValueDto value, int id);
    void deleteValue(int id);
    List<ValueDto>getValueByFeature(FeatureDto feature);
}
