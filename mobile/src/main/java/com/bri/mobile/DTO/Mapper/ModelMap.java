package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.VersionDto;
import com.bri.mobile.DTO.model.ModelDto;
import com.bri.mobile.Entity.Model;
import com.bri.mobile.Entity.Version;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMap {
    public static ModelDto toModelDto(Model model ){
        return ModelDto.builder()
                .idModel(model.getIdModel())
                .nameModel(model.getNameModel())
                .imgModel(model.getImgModel())
                .descModel(model.getDescModel())
                .state(model.getState())
                .reason(model.getReason())
                .brand(BrandMap.toBrandDto(model.getBrand()))
                .build();
    }
    public static Model toModelEntity(ModelDto modelDto ){
        return Model.builder()
                .idModel(modelDto.getIdModel())
                .nameModel(modelDto.getNameModel())
                .imgModel(modelDto.getImgModel())
                .descModel(modelDto.getDescModel())
                .state(modelDto.getState())
                .reason(modelDto.getReason())
                .brand(BrandMap.toBrandEntity(modelDto.getBrand()))
                .build();
    }
    public static List<ModelDto> toModelListDto(List<Model> models){
        return models.stream()
                .map(model ->toModelDto(model))
                .collect(Collectors.toList());
    }
    public static List<Model> toModelListEntity(List<ModelDto> modelsDto ){
        return modelsDto.stream()
                .map(modelDto ->toModelEntity(modelDto))
                .collect(Collectors.toList());
    }
}
