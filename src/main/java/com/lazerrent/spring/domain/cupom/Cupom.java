package com.lazerrent.spring.domain.cupom;

import java.sql.Timestamp;

import com.lazerrent.spring.domain.imovel.Imovel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cupons")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cupom {

    @Id
    private String id;

    private double porcent_desconto;

    private boolean disponivel; 

    @OneToOne
    @JoinColumn(name="imovel_id")
    private Imovel imovel;

    private Timestamp created_at;

    private Timestamp validate;
}
