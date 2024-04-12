package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.BrandDto;
import com.bri.mobile.Entity.Brand;
import com.bri.mobile.Face.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandFace brandFace;
    @GetMapping("/all")
    List<BrandDto> getAllBrands(){
        return brandFace.getAllBrands();
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
    @DeleteMapping("/delete/{id}")
    void deleteBrand(@PathVariable int id){
        brandFace.deleteBrand(id);
    }
}
