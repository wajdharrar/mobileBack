package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepo extends JpaRepository<Shop,Integer> {
}
