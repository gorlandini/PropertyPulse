package com.example.propertypulse.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Imovel imovel;

    @ManyToOne
    private Locatario locatario;

    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private BigDecimal valorMensal;
    private BigDecimal multa;
    private boolean status;

    @OneToMany(mappedBy = "contrato")
    @JsonManagedReference
    private List<Parcela> parcelas;









}
