package com.bri.mobile.Face;

import com.bri.mobile.Entity.Cart;
import com.bri.mobile.Entity.User;

import java.util.List;

public interface CartFace {
    List<Cart> getAllCarts();
    Cart getCartById(int id);
    Cart addCart(Cart cart);
    Cart updateCart(Cart cart, int id);
    void deleteCart(int id);
}
