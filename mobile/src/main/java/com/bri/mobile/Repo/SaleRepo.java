package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends JpaRepository<Brand.Sale,Integer> {
}
