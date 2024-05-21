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

    @Query("SELECT COUNT(DISTINCT r.idRequest) FROM Request r WHERE r.date = :today")
    Integer countRequest(Timestamp today);

    @Query("SELECT r.state, COUNT(DISTINCT r.idRequest) FROM Request r GROUP BY r.state")
    List<Object[]> countRequestsByState();

    @Query("SELECT d.nameDevice, COUNT(DISTINCT r.idRequest) FROM Request r JOIN r.carts c JOIN c.device d GROUP BY d.nameDevice")
    List<Object[]> countRequestsByDevice();

    @Query("SELECT d.version.model.brand.nameBrand, COUNT(DISTINCT r.idRequest) FROM Request r JOIN r.carts c JOIN c.device d GROUP BY d.version.model.brand.nameBrand")
    List<Object[]> countRequestsByBrand();

    @Query("SELECT d.deviceType.nameType, COUNT(DISTINCT r.idRequest) FROM Request r JOIN r.carts c JOIN c.device d GROUP BY d.deviceType.nameType")
    List<Object[]> countRequestsByDeviceType();

    @Query("SELECT u.name, COUNT(DISTINCT r.idRequest) " +
            "FROM Request r " +
            "JOIN r.carts c " +
            "JOIN c.device d " +
            "JOIN d.providers p " +
            "JOIN User u ON u.idUtilisateur = p.idUser " +
            "GROUP BY u.name")
    List<Object[]> countRequestsByPartner();
    @Query("SELECT SUM(r.repayement) " +
            "FROM Request r " +
            "JOIN r.carts c " +
            "JOIN c.device d " +
            "JOIN d.providers p " +
            "WHERE p.idUser = :userId " +
            "AND r.date = :today")
    Double calculateTotalRepaymentForPartnerAndDate(@Param("userId") Long userId, @Param("today") Timestamp today);

    @Query("SELECT SUM(r.initialPayment) " +
            "FROM Request r " +
            "JOIN r.carts c " +
            "JOIN c.device d " +
            "JOIN d.providers p " +
            "WHERE p.idUser = :userId " +
            "AND r.date = :today")
    Double calculateTotalInitialPaymentForPartnerAndDate(@Param("userId") Long userId, @Param("today") Timestamp today);
    @Query("SELECT COUNT(DISTINCT r.idRequest) " +
            "FROM Request r " +
            "JOIN r.carts c " +
            "JOIN c.device d " +
            "JOIN d.providers p " +
            "WHERE p.idUser = :userId")
    Long countRequestsForPartner(@Param("userId") Long userId);
    @Query("SELECT b.nameBrand, COUNT(r) FROM Request r JOIN r.carts c JOIN c.device d JOIN d.version v JOIN v.model m JOIN m.brand b  WHERE b.idPartner = :userId GROUP BY b.nameBrand")
    List<Object[]> countRequestsByBrandForPartner(@Param("userId") Long userId);

    @Query("SELECT d.nameDevice, COUNT(r) FROM Request r JOIN r.carts c JOIN c.device d JOIN d.version v JOIN v.model m JOIN m.brand b WHERE b.idPartner = :userId GROUP BY d.nameDevice")
    List<Object[]> countRequestsByDeviceForPartner(@Param("userId") Long userId);
    @Query("SELECT m.nameModel, COUNT(r) FROM Request r JOIN r.carts c JOIN c.device d JOIN d.version v JOIN v.model m JOIN m.brand b  WHERE b.idPartner = :userId GROUP BY m.nameModel")
    List<Object[]> countRequestsByModelForPartner(@Param("userId") Long userId);

    @Query("SELECT v.nameVersion, COUNT(r) FROM Request r JOIN r.carts c JOIN c.device d JOIN d.version v JOIN v.model m JOIN m.brand b WHERE b.idPartner = :userId GROUP BY v.nameVersion")
    List<Object[]> countRequestsByVersionForPartner(@Param("userId") Long userId);
    @Query("SELECT dt.nameType, COUNT(r) " +
            "FROM Request r " +
            "JOIN r.carts c " +
            "JOIN c.device d " +
            "JOIN d.deviceType dt " +
            "JOIN d.providers p " +
            "WHERE p.idUser = :userId " +
            "GROUP BY dt.nameType")
    List<Object[]> countRequestsByDeviceType(@Param("userId") Long userId);
    @Query("SELECT r.state, COUNT(r) FROM Request r " +
            "WHERE r.user.idUtilisateur = :userId " +
            "GROUP BY r.state")
    List<Object[]> countRequestsByStateForUser(@Param("userId") Long userId);

}
