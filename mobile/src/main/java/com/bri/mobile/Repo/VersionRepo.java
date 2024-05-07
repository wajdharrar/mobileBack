package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Model;
import com.bri.mobile.Entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepo extends JpaRepository<Version,Integer> {
    List<Version> findByModel(Model model);
    @Query("SELECT v FROM Version v JOIN v.model m JOIN m.brand b WHERE b.idPartner = :partnerId")
    List<Version> findByPartnerId(@Param("partnerId") int partnerId);
    @Query("SELECT v.model.brand.idPartner FROM Version v where v.idVersion = :idVersion")
    Integer findIdPartners(@Param("idVersion") int idVersion);
}
