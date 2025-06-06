package com.lazerrent.spring.domain.imovel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="fotos")
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática de ID
    private Integer id;

    @ManyToOne
    @JoinColumn(name="imoveis")
    private Imovel imovel_id;

    private String url;

    private int ordem;
}
