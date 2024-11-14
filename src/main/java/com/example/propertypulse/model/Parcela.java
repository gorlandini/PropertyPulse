package com.example.propertypulse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorParcela;
    private LocalDate dataInicio;
    private LocalDate dataVencimento;
    private Boolean ativa;

    @ManyToOne
    private Contrato contrato;





}