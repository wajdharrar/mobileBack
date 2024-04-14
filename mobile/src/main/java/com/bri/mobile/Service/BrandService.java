package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.BrandMap;
import com.bri.mobile.DTO.model.BrandDto;
import com.bri.mobile.Entity.Brand;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Enum.State;
import com.bri.mobile.Face.BrandFace;
import com.bri.mobile.Repo.BrandRepo;
import com.bri.mobile.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements BrandFace {
    @Autowired
    BrandRepo brandRepo;
    @Override
    public List<BrandDto> getAllBrands(){
        return BrandMap.toDeviceListDto(brandRepo.findAll());
    }
    public BrandDto getBrandById(int id){
        Optional<Brand> testBrand = brandRepo.findById(id);
        if(testBrand.isPresent()) {
            return BrandMap.toBrandDto(brandRepo.findById(id).get());
        }else{
            throw new RuntimeException("brand not found");
        }
    }
    @Override
    public BrandDto addBrand(BrandDto brand){
        return BrandMap.toBrandDto(brandRepo.save(BrandMap.toBrandEntity(brand)));
    }
    public BrandDto updateBrand(BrandDto brand, int id){
        Optional<Brand> testBrand = brandRepo.findById(id);
        if(testBrand.isPresent()){
            Brand oldBrand=testBrand.get();
            oldBrand.setNameBrand(brand.getNameBrand());
            oldBrand.setLogoBrand(brand.getLogoBrand());
            oldBrand.setDescBrand(brand.getDescBrand());
            return BrandMap.toBrandDto(brandRepo.save(oldBrand));
        }else{
            throw new RuntimeException("brand not found");
        }
    }
    public BrandDto updateState(BrandDto brandState, int id){
        Optional<Brand> testBrand = brandRepo.findById(id);
        if(testBrand.isPresent()){
            Brand oldBrand=testBrand.get();
            oldBrand.setState(brandState.getState());
            return BrandMap.toBrandDto(brandRepo.save(oldBrand));
        }else{
            throw new RuntimeException("brand not found");
        }
    }
    public void deleteBrand(int id){
        brandRepo.deleteById(id);
    }
}
