package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.BrandDto;


import java.util.List;

public interface BrandFace {
    List<BrandDto> getAllBrands();
    BrandDto getBrandById(int id);
    BrandDto addBrand(BrandDto brand);
    BrandDto updateBrand(BrandDto brand, int id);
    void deleteBrand(int id);
    public BrandDto updateState(BrandDto brandState, int id);
    }
