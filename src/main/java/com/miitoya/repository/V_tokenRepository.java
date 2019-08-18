package com.miitoya.repository;

import com.miitoya.model.V_token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface V_tokenRepository extends JpaRepository<V_token, String> {
}
