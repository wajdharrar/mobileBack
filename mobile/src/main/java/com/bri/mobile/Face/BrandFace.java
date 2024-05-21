package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.BrandDto;

import com.bri.mobile.tool.stat.EntityStateCount;


import java.util.List;

public interface BrandFace {
    List<BrandDto> getAllBrands();
    BrandDto getBrandById(int id);
    BrandDto addBrand(BrandDto brand);
    BrandDto updateBrand(BrandDto brand, int id);
    void deleteBrand(int id);
    public BrandDto updateState(BrandDto brandState, int id);
    public List<BrandDto> getBrandsByPartner(int idPartner);
    public List<EntityStateCount> countBrandsByState(Long id);
    }
