package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.BrandMap;
import com.bri.mobile.DTO.Mapper.ModelMap;
import com.bri.mobile.DTO.model.ModelDto;
import com.bri.mobile.Entity.Brand;
import com.bri.mobile.Entity.Model;
import com.bri.mobile.Repo.ModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    @Autowired
    ModelRepo modelRepo;
    public List<ModelDto> getAllModels(){
        return ModelMap.toModelListDto(modelRepo.findAll());
    }
    ModelDto getModelById(int id){
        Optional<Model> testModel = modelRepo.findById(id);
        if(testModel.isPresent()){
            return ModelMap.toModelDto(testModel.get());
        }else {
            throw new RuntimeException("model not found");
        }
    }
    ModelDto addModel(ModelDto model){
        return ModelMap.toModelDto(modelRepo.save(ModelMap.toModelEntity(model)));
    }
    ModelDto updateModel(ModelDto model, int id){
        Optional<Model> testModel = modelRepo.findById(id);
        if(testModel.isPresent()){
            Model oldModel=testModel.get();
            oldModel.setNameModel(model.getNameModel());
            oldModel.setImgModel(model.getImgModel());
            oldModel.setDescModel(model.getDescModel());
            return ModelMap.toModelDto(modelRepo.save(oldModel));
        }else{
            throw new RuntimeException("brand not found");
        }
    }
    void deleteModel(int id){
        modelRepo.deleteById(id);
    }
}
