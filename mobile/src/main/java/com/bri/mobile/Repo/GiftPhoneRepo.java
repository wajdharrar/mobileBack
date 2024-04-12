package com.bri.mobile.Repo;

import com.bri.mobile.Entity.GiftPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftPhoneRepo extends JpaRepository<GiftPhone,Integer> {
}
