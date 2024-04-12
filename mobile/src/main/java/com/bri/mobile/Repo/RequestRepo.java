package com.bri.mobile.Repo;

import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepo extends JpaRepository<Request,Integer> {
    @Query("SELECT r FROM Request r WHERE r.user = :user")
    List<Request> findByIdUser(@Param("user") User user);
}
