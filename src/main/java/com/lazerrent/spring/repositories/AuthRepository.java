package com.lazerrent.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazerrent.spring.domain.usuario.Auth;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    
    Optional<Auth> findByEmail(String email);
}

