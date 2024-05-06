package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.FeatureVersionMap;
import com.bri.mobile.DTO.model.FeatureVersionDto;
import com.bri.mobile.Entity.Feature;
import com.bri.mobile.Entity.FeatureVersion;
import com.bri.mobile.Entity.FeatureVersionId;
import com.bri.mobile.Face.FeatureVersionFace;
import com.bri.mobile.Repo.FeatureRepo;
import com.bri.mobile.Repo.FeatureVersionRepo;
import com.bri.mobile.tool.FeatureValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
@Service
public class FeatureVersionService implements FeatureVersionFace {
    @Autowired
    FeatureVersionRepo featureVersionRepo;
    @Autowired
    FeatureRepo featureRepo;
    @Override
    public List<FeatureVersionDto> addFeaturesToVersion(List<FeatureValue>values, int idVersion){
        List<FeatureVersionDto> featureVersionDtos=new ArrayList<>(values.size());
        for (int i=0;i<values.size();i++){
            Optional<Feature> featureTest=featureRepo.findById(values.get(i).getIdFeature());
            if(featureTest.isPresent()){
                FeatureVersionId featureVersionId=new FeatureVersionId(values.get(i).getIdFeature(),idVersion);
                FeatureVersion newFeatureVersion= new FeatureVersion(featureVersionId,values.get(i).getValue());
                featureVersionDtos.add(FeatureVersionMap.toFeatureVersionDto(featureVersionRepo.save(newFeatureVersion)));
            }else{
                throw new RuntimeException("feature with id "+values.get(i)+" Not Found");
            }
        }
        return featureVersionDtos;
    }
    @Override
    public List<FeatureVersionDto> getAllFeaturesByIdVersion(int idVersion){
        List <Feature> values= featureRepo.findByVersionId(idVersion);
        if(!values.isEmpty()){
            List<FeatureVersionDto> featureVersionDtos = new ArrayList<>(values.size());
            for (Feature value : values) {
                FeatureVersionId featureVersionId = new FeatureVersionId(value.getIdFeature(), idVersion);
                featureVersionDtos.add(FeatureVersionMap.toFeatureVersionDto(featureVersionRepo.findById(featureVersionId).get()));
            }
            return featureVersionDtos;
        }else{
            throw new RuntimeException("features Not Found");
        }
    }
}
