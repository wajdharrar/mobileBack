package com.bri.mobile.Repo;

import com.bri.mobile.DTO.model.ModelDto;
import com.bri.mobile.Entity.Brand;
import com.bri.mobile.Entity.Model;
import com.bri.mobile.Entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepo extends JpaRepository<Model,Integer> {
    List<Model> findByBrand(Brand brand);
}
