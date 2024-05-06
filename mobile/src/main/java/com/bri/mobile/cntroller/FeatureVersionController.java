package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.FeatureVersionDto;

import com.bri.mobile.Face.FeatureVersionFace;
import com.bri.mobile.tool.FeatureValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/faetureversion")
public class FeatureVersionController {
    @Autowired
    FeatureVersionFace featureVersionFace;
    @PostMapping("/add/{id}")
    public List<FeatureVersionDto> addFeaturesToVersion(@RequestBody List<FeatureValue> values, @PathVariable int id){
        return featureVersionFace.addFeaturesToVersion(values,id);
    }
    @GetMapping("/{id}")
    public List<FeatureVersionDto> getAllFeaturesByIdVersion(@PathVariable int id){
        return featureVersionFace.getAllFeaturesByIdVersion(id);
    }
}
