package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.SaleDto;
import com.bri.mobile.Entity.Brand;

public class SaleMap {
    public static SaleDto toSaleDto(Brand.Sale sale){
        return SaleDto.builder()
                .idSale(sale.getIdSale())
                .value(sale.getValue())
                .startDate(sale.getStartDate())
                .endDate(sale.getEndDate())
                .state(sale.getState())
                .reason(sale.getReason())
                .build();
    }
    public static Brand.Sale toSaleEntity(SaleDto saleDto){
        return Brand.Sale.builder()
                .idSale(saleDto.getIdSale())
                .value(saleDto.getValue())
                .startDate(saleDto.getStartDate())
                .endDate(saleDto.getEndDate())
                .state(saleDto.getState())
                .reason(saleDto.getReason())
                .build();
    }
}
