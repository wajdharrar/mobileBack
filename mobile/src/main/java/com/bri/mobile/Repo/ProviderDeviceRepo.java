package com.bri.mobile.Repo;

import com.bri.mobile.Entity.ProviderDevice;
import com.bri.mobile.Entity.ProviderDeviceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderDeviceRepo extends JpaRepository<ProviderDevice, ProviderDeviceId> {
}
