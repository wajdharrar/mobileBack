package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepo extends JpaRepository<Value,Integer> {
}
