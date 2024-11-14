package com.example.propertypulse.repository;

import com.example.propertypulse.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    List<Contrato> findByLocatarioNome(String nomeLocatario);
}
