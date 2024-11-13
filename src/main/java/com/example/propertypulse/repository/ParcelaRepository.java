package com.example.propertypulse.repository;



import com.example.propertypulse.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Long> {

    // Você pode adicionar métodos customizados de consulta aqui, por exemplo:

    // Encontrar todas as parcelas de um contrato
    List<Parcela> findByContratoId(Long contratoId);

    // Encontrar parcelas pelo status
    List<Parcela> findByAtiva(Boolean ativa);

    // Encontrar parcelas com base na data de vencimento
    List<Parcela> findByDataVencimentoBefore(LocalDate dataVencimento);

    // Caso precise de um método customizado, por exemplo, buscar parcelas por valor
    List<Parcela> findByValorParcelaGreaterThan(BigDecimal valor);
}

