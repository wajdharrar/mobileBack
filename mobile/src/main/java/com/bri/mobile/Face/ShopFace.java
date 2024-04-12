package com.bri.mobile.Face;

import com.bri.mobile.Entity.Role;
import com.bri.mobile.Entity.Shop;

import java.util.List;

public interface ShopFace {
    List<Shop> getAllShops();
    Shop getShopById(int id);
    Shop addShop(Shop shop);
    Shop updateShop(Shop shop, int id);
    void deleteShop(int id);
}
