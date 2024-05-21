package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Device;
import com.bri.mobile.Entity.DeviceType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceRepo extends JpaRepository<Device,Integer> {
    List<Device> findByDeviceType(DeviceType deviceType);
    @Query("SELECT d.state, COUNT(d) FROM Device d JOIN d.version v JOIN v.model m JOIN m.brand b WHERE b.idPartner = :idPartner GROUP BY d.state")
    List<Object[]> countDevicesByState(@Param("idPartner") Long idPartner);
    @Query("SELECT b.nameBrand, COUNT(d) FROM Device d JOIN d.version v JOIN v.model m JOIN m.brand b WHERE b.idPartner = :idPartner GROUP BY b.nameBrand")
    List<Object[]> countDevicesByBrand(@Param("idPartner") Long idPartner);

    @Query("SELECT m.nameModel, COUNT(d) FROM Device d JOIN d.version v JOIN v.model m JOIN m.brand b WHERE b.idPartner = :idPartner GROUP BY m.nameModel")
    List<Object[]> countDevicesByModel(@Param("idPartner") Long idPartner);
    @Query("SELECT dt.nameType, COUNT(d) " +
            "FROM Device d " +
            "JOIN d.deviceType dt " +
            "JOIN d.version v " +
            "JOIN v.model m " +
            "JOIN m.brand b " +
            "WHERE b.idPartner = :idPartner " +
            "GROUP BY dt.nameType")
    List<Object[]> countDevicesByDeviceType(@Param("idPartner") Long idPartner);
    @Query("SELECT d " +
            "FROM Device d WHERE " +
            "d.deviceType.nameType IN :deviceTypes " +
            "AND d.price BETWEEN :minPrice AND :maxPrice")
    List<Device> findRecommendedDevices(@Param("deviceTypes") List<String> deviceTypes,
                                        @Param("minPrice") Double minPrice,
                                        @Param("maxPrice") Double maxPrice,
                                        Pageable pageable);
}
