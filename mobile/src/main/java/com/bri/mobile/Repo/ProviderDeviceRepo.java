package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Device;
import com.bri.mobile.Entity.ProviderDevice;
import com.bri.mobile.Entity.ProviderDeviceId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProviderDeviceRepo extends JpaRepository<ProviderDevice, ProviderDeviceId> {
    @Query("SELECT d FROM ProviderDevice pd JOIN Device d ON pd.id.idDevice = d.id ORDER BY pd.createdAt DESC")
    List<Device> findTop8DevicesOrderByCreatedAtDesc(Pageable pageable);
}
