package com.bri.mobile.Repo;

import com.bri.mobile.Entity.FeatureVersion;
import com.bri.mobile.Entity.FeatureVersionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureVersionRepo extends JpaRepository<FeatureVersion, FeatureVersionId> {
}
