package com.bri.mobile.Face;

import com.bri.mobile.Entity.Brand;
import com.bri.mobile.Entity.User;

import java.util.List;

public interface SaleFace {
    List<Brand.Sale> getAllSales();
    Brand.Sale getSaleById(int id);
    Brand.Sale addSale(Brand.Sale sale);
    Brand.Sale updateSale(Brand.Sale sale, int id);
    void deleteSale(int id);
}
