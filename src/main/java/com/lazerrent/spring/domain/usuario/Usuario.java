package com.lazerrent.spring.domain.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    private Integer id;

    private String nome;

    private String sobrenome;

    private String telefone;

    private String cpf;

    private Date data_nascimento;

    @ManyToAny
    @JoinColumn(name="status_usuario_id")
    private Status_Usuario status_Usuario;

    private String endereco;

    private String bairro;

    private String cidade;

    private String estado;

    private Timestamp created_at;

    private Timestamp updated_at;

    private Timestamp lastlogin_at;
}
