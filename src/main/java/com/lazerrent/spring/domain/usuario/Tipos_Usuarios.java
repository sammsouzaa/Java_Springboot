package com.lazerrent.spring.domain.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tipos_usuarios")
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Tipos_Usuarios {

    @Id
    private Integer id;

    private String nome;

    private String descricao;
}
