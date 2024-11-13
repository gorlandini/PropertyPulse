package com.example.propertypulse.service;

import com.example.propertypulse.model.Parcela;
import com.example.propertypulse.repository.ParcelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ParcelaService {

    private final ParcelaRepository parcelaRepository;

    @Autowired
    public ParcelaService(ParcelaRepository parcelaRepository) {
        this.parcelaRepository = parcelaRepository;
    }

    // Método para salvar uma parcela
    public Parcela salvarParcela(Parcela parcela) {
        return parcelaRepository.save(parcela);
    }

    // Método para buscar todas as parcelas
    public List<Parcela> listarParcelas() {
        return parcelaRepository.findAll();
    }

    // Método para encontrar uma parcela por ID
    public Optional<Parcela> buscarParcelaPorId(Long id) {
        return parcelaRepository.findById(id);
    }

    // Método para listar parcelas de um contrato específico
    public List<Parcela> listarParcelasPorContrato(Long contratoId) {
        return parcelaRepository.findByContratoId(contratoId);
    }

    // Método para listar parcelas por status
    public List<Parcela> listarParcelasPorStatus(Boolean ativa) {
        return parcelaRepository.findByAtiva(ativa);
    }

    // Método para buscar parcelas que venceram antes de uma certa data
    public List<Parcela> listarParcelasVencidas(LocalDate dataVencimento) {
        return parcelaRepository.findByDataVencimentoBefore(dataVencimento);
    }
}
