package com.lazerrent.spring.domain.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="status_usuario")
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Status_Usuario {

    @Id
    private Integer id;

    private String status;
}
