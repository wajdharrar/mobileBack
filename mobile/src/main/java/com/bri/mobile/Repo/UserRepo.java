package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Role;
import com.bri.mobile.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    Optional<User> findByEmail(String email);

    List<User> findByRole(Role role);
}
