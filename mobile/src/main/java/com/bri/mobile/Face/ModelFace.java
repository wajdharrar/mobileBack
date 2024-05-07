package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.ModelDto;
import com.bri.mobile.Entity.Brand;


import java.util.List;

public interface ModelFace {
    List<ModelDto> getAllModels();
    ModelDto getModelById(int id);
    ModelDto addModel(ModelDto model);
    ModelDto updateModel(ModelDto model, int id);
    void deleteModel(int id);
    List<ModelDto> getModelByBrand(Brand brand);
    public List<ModelDto> getAllModelsByPartner(int idPartner);
    public Integer getAllPartnersId(int idModel);
}
