package com.lazerrent.spring.domain.usuario;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
@Table(name="usuarios_tipos")
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Usuarios_Tipos {

    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="tipo_usuario_id")
    private Tipos_Usuarios tipos_Usuarios;

    private Timestamp created_at;
    
}
