package com.lazerrent.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazerrent.spring.domain.usuario.DTO.LoginRequestDTO;
import com.lazerrent.spring.domain.usuario.DTO.LoginResponseDTO;
import com.lazerrent.spring.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO response = authService.authenticate(loginRequest);
        return ResponseEntity.ok(response);
    }

    
}
