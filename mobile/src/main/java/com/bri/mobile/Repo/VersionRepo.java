package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepo extends JpaRepository<Version,Integer> {
}
