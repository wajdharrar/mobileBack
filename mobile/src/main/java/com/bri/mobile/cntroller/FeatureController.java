package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.FeatureDto;
import com.bri.mobile.Face.FeatureFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feature")
public class FeatureController {
    @Autowired
    FeatureFace featureFace;
    @GetMapping("/all")
    List<FeatureDto> getAllFeatures(){
        return featureFace.getAllFeatures();
    }
    @GetMapping("/device/{id}")
    List<FeatureDto> getFeaturesByDeviceType(@PathVariable int id){
        return featureFace.getFeaturesByDeviceType(id);
    }
    @GetMapping("/version/{id}")
    List<FeatureDto> getByVersionId(@PathVariable int id){
        return featureFace.getByVersionId(id);
    }
    @GetMapping("/{id}")
    FeatureDto getFeatureById(@PathVariable int id){
        return featureFace.getFeatureById(id);
    }
}
