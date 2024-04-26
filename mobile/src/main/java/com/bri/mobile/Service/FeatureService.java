package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.FeatureMap;
import com.bri.mobile.DTO.model.FeatureDto;
import com.bri.mobile.Face.FeatureFace;
import com.bri.mobile.Repo.FeatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeatureService implements FeatureFace {
    @Autowired
    FeatureRepo featureRepo;
    @Override
    public List<FeatureDto> getAllFeatures(){
        return FeatureMap.toFeatureListDto(featureRepo.findAll()) ;   }
    @Override
    public FeatureDto getFeatureById(int id){return null;}
    @Override
    public FeatureDto addFeature(FeatureDto feature){return null;}
    @Override
    public FeatureDto updateFeature(FeatureDto feature, int id){return null;}
    @Override
    public void deleteFeature(int id){return;}
    @Override
    public List<FeatureDto> getFeaturesByDeviceType(int idDeviceType){
        return FeatureMap.toFeatureListDto(featureRepo.findByIdDeviceType(idDeviceType));
    }
    @Override
    public List<FeatureDto> getByVersionId(int idVersion){
        return FeatureMap.toFeatureListDto(featureRepo.findByVersionId(idVersion));
    }
}
