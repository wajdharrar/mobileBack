package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Cart;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.UserPhoneId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Integer> {
    List<Cart> findByRequest(Request request);
}
