package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.FeatureMap;
import com.bri.mobile.DTO.Mapper.ValueMap;
import com.bri.mobile.DTO.model.FeatureDto;
import com.bri.mobile.DTO.model.ValueDto;
import com.bri.mobile.Face.ValueFace;
import com.bri.mobile.Repo.ValueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ValueService implements ValueFace {
    @Autowired
    ValueRepo valueRepo;
    public List<ValueDto> getAllValues(){
        return null;
    }
    public ValueDto getValueById(int id){
        return null;
    }
    public ValueDto addValue(ValueDto value){
        return null;
    }
    public ValueDto updateValue(ValueDto value, int id){
        return null;
    }
    public void deleteValue(int id){
        return;
    }
    public List<ValueDto>getValueByFeature(FeatureDto feature){
        return ValueMap.toValueListDto(valueRepo.findByFeature(FeatureMap.toFeatureEntity(feature)));
    }
}
