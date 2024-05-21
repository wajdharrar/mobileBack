package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.BrandDto;

import com.bri.mobile.Face.*;

import com.bri.mobile.tool.stat.EntityStateCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandFace brandFace;
    @GetMapping("/all")
    List<BrandDto> getAllBrands(){
        return brandFace.getAllBrands();
    }
    @GetMapping("/all/{idPartner}")
    List<BrandDto> getAllBrandsByIdPartner(@PathVariable int idPartner){
        return brandFace.getBrandsByPartner(idPartner);
    }
    @PostMapping("/add")
    BrandDto addBrand(@RequestBody BrandDto brand){
        System.out.println(brand);
        return  brandFace.addBrand(brand);
    }
    @GetMapping("/{id}")
    BrandDto getBrandById(@PathVariable int id ){
        return brandFace.getBrandById(id);
    }
    @PutMapping("/update/{id}")
    BrandDto updateBrand(@PathVariable int id ,@RequestBody BrandDto brand){
        return brandFace.updateBrand(brand,id);
    }
    @PutMapping("/updatestate/{id}")
    BrandDto updateState(@PathVariable int id ,@RequestBody BrandDto brandState){
        return brandFace.updateState(brandState,id);
    }
    @DeleteMapping("/delete/{id}")
    void deleteBrand(@PathVariable int id){
        brandFace.deleteBrand(id);
    }
    @GetMapping("/count/state/{id}")
    List<EntityStateCount> countBrandsByState(@PathVariable Long id){
        return  brandFace.countBrandsByState(id);
    }
}
