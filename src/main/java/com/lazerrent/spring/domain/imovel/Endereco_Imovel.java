package com.lazerrent.spring.domain.imovel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="endereco_imoveis")
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Endereco_Imovel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática de ID
    private Integer id;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private double longitude;

    private double latitude;

    private String cep;

    @OneToOne
    @JoinColumn(name="imovel_id")
    private Imovel imovel;
}