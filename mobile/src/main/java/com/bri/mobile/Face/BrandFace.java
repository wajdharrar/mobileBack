package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.BrandDto;
import com.bri.mobile.Entity.Brand;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Enum.State;

import java.util.List;
import java.util.Optional;

public interface BrandFace {
    List<BrandDto> getAllBrands();
    BrandDto getBrandById(int id);
    BrandDto addBrand(BrandDto brand);
    BrandDto updateBrand(BrandDto brand, int id);
    void deleteBrand(int id);
    public BrandDto updateState(BrandDto brandState, int id);
    }
