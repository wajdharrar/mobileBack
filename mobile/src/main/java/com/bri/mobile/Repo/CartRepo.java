package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Cart;
import com.bri.mobile.Entity.Request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.sql.Timestamp;
import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Integer> {
    List<Cart> findByRequest(Request request);
    @Query("SELECT d.idDevice, d.nameDevice, COUNT(c.device.id) as request_count " +
            "FROM Cart c " +
            "JOIN c.request r " +
            "JOIN c.device d " +
            "WHERE r.date >= :startOfWeek AND r.date <= :endOfWeek " +
            "GROUP BY d.idDevice, d.nameDevice " +
            "ORDER BY request_count DESC")
    List<Object[]> findTopRequestedDevicesForCurrentWeek(@Param("startOfWeek") Timestamp startOfWeek,
                                                         @Param("endOfWeek") Timestamp endOfWeek,
                                                         Pageable pageable);
}
