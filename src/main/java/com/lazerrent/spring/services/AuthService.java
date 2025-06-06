package com.lazerrent.spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazerrent.spring.domain.usuario.Auth;
import com.lazerrent.spring.domain.usuario.Usuario;
import com.lazerrent.spring.domain.usuario.DTO.LoginRequestDTO;
import com.lazerrent.spring.domain.usuario.DTO.LoginResponseDTO;
import com.lazerrent.spring.infra.security.JwtTokenProvider;
import com.lazerrent.spring.repositories.AuthRepository;
import com.lazerrent.spring.repositories.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Para hash de senhas

    @Autowired
    private JwtTokenProvider jwtTokenProvider; // Para gerar tokens JWT

    public LoginResponseDTO authenticate(LoginRequestDTO loginRequest) {
        // 1. Verificar se o email existe
        Auth auth = authRepository.findByEmail(loginRequest.getEmail())
            .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));

        // 2. Verificar se a senha está correta
        if (!passwordEncoder.matches(loginRequest.getPassword(), auth.getPassword())) {
            throw new RuntimeException("Email ou senha inválidos");
        }

        // 3. Verificar se o tipo está associado ao usuário
        Usuario usuario = usuarioRepository.findByEmailAndTipo(loginRequest.getEmail(), loginRequest.getTipo())
            .orElseThrow(() -> new RuntimeException("Permissão negada para o tipo de conta solicitado"));

        // 4. Gerar um token JWT
        List<String> roles = usuario.getUsuarioTipos().stream()
            .map(ut -> ut.getTipoUsuario().getNome())
            .collect(Collectors.toList());
        String token = jwtTokenProvider.generateToken(auth.getEmail(), roles);

        // 5. Retornar o token e as roles
        LoginResponseDTO response = new LoginResponseDTO();
        response.setToken(token);
        response.setRoles(roles);

        return response;
    }

    
}

