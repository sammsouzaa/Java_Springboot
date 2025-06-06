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


@Table(name="caracteristicas_basicas")
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Caracteristicas_Basicas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática de ID
    private Integer id;

    private boolean permitido_animais;

    private boolean estacionamento_incluido;

    private boolean cozinha;

    private boolean brinquedos_infantis;

    private boolean freezer;

    private boolean geladeira;

    private boolean fogao;

    private boolean cooktop;

    private boolean wifi;

    private boolean microondas;

    private boolean cameras;

    private boolean tv;

    private boolean caixa_de_som;

    private boolean churrasqueira;

    private boolean mesa_ping_pong;

    private boolean mesa_sinuca;

    private boolean mesa_penbolim;

    private boolean cama_elastica;

    private boolean banheiro_cadeirante;

    @OneToOne
    @JoinColumn(name="imovel_id")
    private Imovel imovel;
}
