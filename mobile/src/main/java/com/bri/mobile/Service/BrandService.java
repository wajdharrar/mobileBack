package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.BrandMap;
import com.bri.mobile.DTO.model.BrandDto;
import com.bri.mobile.Entity.Brand;

import com.bri.mobile.Enum.State;
import com.bri.mobile.Face.BrandFace;
import com.bri.mobile.Repo.BrandRepo;

import com.bri.mobile.tool.stat.EntityStateCount;
import com.bri.mobile.tool.stat.RequestStateCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            oldBrand.setIdPartner(brand.getIdPartner());
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
    public List<BrandDto> getBrandsByPartner(int idPartner){
        return BrandMap.toDeviceListDto(brandRepo.findByIdPartner(idPartner));}
    public List<EntityStateCount> countBrandsByState(Long id) {
        List<Object[]> brandStateCount = brandRepo.countBrandsByState(id);

        return brandStateCount.stream()
                .map(objects -> new EntityStateCount((State) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
}
