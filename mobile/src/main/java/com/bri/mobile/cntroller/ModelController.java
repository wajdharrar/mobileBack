package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.ModelDto;

import com.bri.mobile.Entity.Brand;

import com.bri.mobile.Face.ModelFace;
import com.bri.mobile.tool.stat.EntityStateCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    ModelFace modelFace;
    @GetMapping("/all")
    List<ModelDto> getAllBrands(){
        return modelFace.getAllModels();
    }
    @GetMapping("/all/{idPartner}")
    List<ModelDto> getAllBrandsByPartner(@PathVariable int idPartner){
        return modelFace.getAllModelsByPartner(idPartner);
    }
    @GetMapping("/idPartners/{idVersion}")
    public Integer getAllPartnersId(@PathVariable int idVersion){
        return modelFace.getAllPartnersId(idVersion);
    }
    @PostMapping("/add")
    ModelDto addBrand(@RequestBody ModelDto model){
        return  modelFace.addModel(model);
    }
    @GetMapping("/{id}")
    ModelDto getBrandById(@PathVariable int id ){
        return modelFace.getModelById(id);
    }
    @PutMapping("/update/{id}")
    ModelDto updateBrand(@PathVariable int id ,@RequestBody ModelDto model){
        return modelFace.updateModel(model,id);
    }
    @DeleteMapping("/delete/{id}")
    void deleteBrand(@PathVariable int id){
        modelFace.deleteModel(id);
    }
    @PostMapping("brand")
    List<ModelDto> getAllModelsByBrand(@RequestBody Brand brand){
        return modelFace.getModelByBrand(brand);
    }
    @GetMapping("/count/state/{id}")
    List<EntityStateCount>countModelsByState(@PathVariable Long id){
        return modelFace.countModelsByState(id);
    }
}
