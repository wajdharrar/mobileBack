package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.BrandDto;
import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.Entity.Brand;
import com.bri.mobile.Entity.Device;

import java.util.List;
import java.util.stream.Collectors;

public class BrandMap {
    public static BrandDto  toBrandDto(Brand brand){
        return BrandDto.builder()
                .idBrand(brand.getIdBrand())
                .nameBrand(brand.getNameBrand())
                .logoBrand(brand.getLogoBrand())
                .descBrand(brand.getDescBrand())
                .reason(brand.getReason())
                .state(brand.getState())
                .build();

    }
    public static Brand toBrandEntity (BrandDto brandDto){
        return Brand.builder()
                .idBrand(brandDto.getIdBrand())
                .nameBrand(brandDto.getNameBrand())
                .logoBrand(brandDto.getLogoBrand())
                .descBrand(brandDto.getDescBrand())
                .state(brandDto.getState())
                .reason(brandDto.getReason())
                .build();
    }
    public static List<BrandDto> toDeviceListDto(List<Brand> brands ){
        return brands.stream()
                .map(brand ->toBrandDto(brand))
                .collect(Collectors.toList());
    }
    public static List<Brand> toDeviceListEntity(List<BrandDto> brandsDto ){
        return brandsDto.stream()
                .map(brandDto ->toBrandEntity(brandDto))
                .collect(Collectors.toList());
    }
}
