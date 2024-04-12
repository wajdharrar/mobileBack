package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepo extends JpaRepository<Feature,Integer> {
}
