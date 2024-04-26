package com.bri.mobile.Repo;

import com.bri.mobile.Entity.DeviceType;
import com.bri.mobile.Entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepo extends JpaRepository<Feature,Integer> {
    List<Feature> findByIdDeviceType(int idDeviceType);
    @Query("SELECT f FROM Feature f JOIN f.versions v WHERE v.idVersion = :versionId")
    List<Feature> findByVersionId(@Param("versionId") int versionId);
}
