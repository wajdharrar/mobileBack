package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RequestRepo extends JpaRepository<Request,Integer> {
    List<Request> findByUser(User user);

    @Query("SELECT SUM(r.repayement) FROM Request r WHERE r.date = :today")
    Double calculateTotalRepaymentForToday(Timestamp today);

    @Query("SELECT SUM(r.initialPayment) FROM Request r WHERE r.date = :today")
    Double calculateTotalInitialPaymentForToday(Timestamp today);

    @Query("SELECT COUNT(r) FROM Request r WHERE r.date = :today")
    Integer countRequest(Timestamp today);

    @Query("SELECT r.state, COUNT(r) FROM Request r GROUP BY r.state")
    List<Object[]> countRequestsByState();

    @Query("SELECT d.nameDevice, COUNT(r) FROM Request r JOIN r.carts c JOIN c.device d GROUP BY d.nameDevice")
    List<Object[]> countRequestsByDevice();

    @Query("SELECT d.version.model.brand.nameBrand, COUNT(r) FROM Request r JOIN r.carts c JOIN c.device d GROUP BY d.version.model.brand.nameBrand")
    List<Object[]> countRequestsByBrand();

    @Query("SELECT d.deviceType.nameType, COUNT(r) FROM Request r JOIN r.carts c JOIN c.device d GROUP BY d.deviceType.nameType")
    List<Object[]> countRequestsByDeviceType();

    @Query("SELECT u.name, COUNT(r) FROM Request r JOIN r.user u GROUP BY u.name")
    List<Object[]> countRequestsByPartner();
}
