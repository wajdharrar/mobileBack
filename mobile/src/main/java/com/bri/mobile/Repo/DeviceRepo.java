package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Device;
import com.bri.mobile.Entity.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepo extends JpaRepository<Device,Integer> {
    List<Device> findByDeviceType(DeviceType deviceType);
}
