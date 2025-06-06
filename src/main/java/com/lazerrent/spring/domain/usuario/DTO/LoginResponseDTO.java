package com.lazerrent.spring.domain.usuario.DTO;

import java.util.List;

public class LoginResponseDTO {
    private String token; // JWT token para autenticação
    private List<String> roles; // Tipos associados ao usuário
}
