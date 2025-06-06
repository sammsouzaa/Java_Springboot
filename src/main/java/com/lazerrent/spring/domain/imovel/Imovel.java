package com.lazerrent.spring.domain.imovel;

import java.sql.Timestamp;

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


@Table(name="imoveis")
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática de ID
    private Integer id; // Mudou para Integer
    
    private String nome;

    private double preco;

    private String endereco_format;

    private double temp_desconto_semana;
    private double temp_desconto_fds_feriado;
    private double nottemp_desconto_semana;
    private double nottemp_desconto_fes_feriado;

    private String descricao_detalhada;

    private String descricao_basica;

    private int soma_notas;

    private int quantidade_avaliacoes;

    private double media_avaliacao;

    private int quartos;

    private int banheiros;

    private double tamanho_espaço_aberto;

    private double tamanho_espaço_coberto; 

    private int capacidade_maxima;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Categoria category;

    @ManyToOne
    @JoinColumn(name="status_id")
    private Status_Imovel status;

    private Timestamp created_at;

    private Timestamp updated_at;
}
