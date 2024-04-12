package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.BrandDto;
import com.bri.mobile.DTO.model.ModelDto;
import com.bri.mobile.Face.BrandFace;
import com.bri.mobile.Face.ModelFace;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
@CrossOrigin("*")
public class ModelController {
    ModelFace modelFace;
    @GetMapping("/all")
    List<ModelDto> getAllBrands(){
        return modelFace.getAllModels();
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
}
