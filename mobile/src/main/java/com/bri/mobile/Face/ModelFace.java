package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.BrandDto;
import com.bri.mobile.DTO.model.ModelDto;

import java.util.List;

public interface ModelFace {
    List<ModelDto> getAllModels();
    ModelDto getModelById(int id);
    ModelDto addModel(ModelDto model);
    ModelDto updateModel(ModelDto model, int id);
    void deleteModel(int id);
}
