package com.example.propertypulse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    @ManyToOne
    private Proprietario proprietario;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    private BigDecimal valorTotal;
    private Short disponibilidadeTempo;

}
