package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Model;
import com.bri.mobile.Entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepo extends JpaRepository<Version,Integer> {
    List<Version> findByModel(Model model);
}
