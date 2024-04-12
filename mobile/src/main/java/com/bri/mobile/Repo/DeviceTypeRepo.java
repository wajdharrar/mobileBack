package com.bri.mobile.Repo;

import com.bri.mobile.Entity.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeRepo extends JpaRepository<DeviceType,Integer> {
}
