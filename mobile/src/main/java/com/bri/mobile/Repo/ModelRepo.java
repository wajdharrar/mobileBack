package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Brand;
import com.bri.mobile.Entity.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepo extends JpaRepository<Model,Integer> {
    List<Model> findByBrand(Brand brand);
    @Query("SELECT m FROM Model m JOIN m.brand b WHERE b.idPartner = :partnerId")
    List<Model> findByIdPartner(@Param("partnerId") int partnerId);
    @Query("SELECT m.brand.idPartner FROM Model m WHERE m.idModel = :idModel")
    Integer findIdPartners(@Param("idModel") int idModel);
}
