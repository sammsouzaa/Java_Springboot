package com.lazerrent.spring.domain.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Table(name="auth")
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Auth {

    @Id
    private Integer id;

    private String email;

    private String senha;

    @OneToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}
