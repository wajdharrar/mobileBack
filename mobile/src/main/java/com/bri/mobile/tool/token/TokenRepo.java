package com.bri.mobile.tool.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token,Integer> {
    @Query("select t from Token t inner join t.user u where u.id = :idUser and (t.expired = false or t.revoked = false)")
    List<Token> findAllValidTokenByUser(@Param("idUser") int idUser);

    Optional<Token>findByToken(String token);
}
