package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepo extends JpaRepository<Brand,Integer> {
    List<Brand> findByIdPartner(int idPartner);
}
