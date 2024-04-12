package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepo extends JpaRepository<Gift,Integer> {
}
