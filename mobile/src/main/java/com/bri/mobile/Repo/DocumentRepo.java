package com.bri.mobile.Repo;

import com.bri.mobile.Entity.Document;
import com.bri.mobile.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends JpaRepository<Document,Integer> {
    Document findByRequest(Request request);
}
