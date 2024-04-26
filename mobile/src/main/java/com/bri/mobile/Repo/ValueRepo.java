package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Feature;
import com.bri.mobile.Entity.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValueRepo extends JpaRepository<Value,Integer> {
    List<Value> findByFeature(Feature feature);
}
