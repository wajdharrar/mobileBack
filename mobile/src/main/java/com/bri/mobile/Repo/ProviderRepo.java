package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepo extends JpaRepository<Provider,Integer> {
    Provider findByIdUser(int id);
}
