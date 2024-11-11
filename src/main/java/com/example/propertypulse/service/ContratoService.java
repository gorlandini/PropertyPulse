package com.example.propertypulse.service;

import com.example.propertypulse.model.Contrato;
import com.example.propertypulse.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public Contrato salvarContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public List<Contrato> listarContratos() {
        return contratoRepository.findAll();
    }

    public Optional<Contrato> buscarContratoPorId(Long id) {
        return contratoRepository.findById(id);
    }

    public void excluirContrato(Long id) {
        contratoRepository.deleteById(id);
    }

    public Contrato buscarPorId(Long id) {
        return contratoRepository.findById(id).orElse(null);
    }

}
