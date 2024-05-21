package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepo extends JpaRepository<Brand,Integer> {
    List<Brand> findByIdPartner(int idPartner);
    @Query("SELECT b.state, COUNT(b) FROM Brand b WHERE b.idPartner = :idPartner GROUP BY b.state")
    List<Object[]> countBrandsByState(@Param("idPartner") Long idPartner);
}
