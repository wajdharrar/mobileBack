package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.FeatureDto;
import com.bri.mobile.DTO.model.ValueDto;

import com.bri.mobile.Face.ValueFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/value")
public class ValueController {
    @Autowired
    ValueFace valueFace;
    @PostMapping ("/feature")
    List<ValueDto>getValueByFeature(@RequestBody FeatureDto featureDto){
        return valueFace.getValueByFeature(featureDto);
    }
}
