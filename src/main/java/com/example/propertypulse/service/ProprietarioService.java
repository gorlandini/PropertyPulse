package com.example.propertypulse.service;

import com.example.propertypulse.model.Proprietario;
import com.example.propertypulse.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Proprietario salvarProprietario(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    public List<Proprietario> listarProprietarios() {
        return proprietarioRepository.findAll();
    }

    public Optional<Proprietario> buscarProprietarioPorId(Long id) {
        return proprietarioRepository.findById(id);
    }

    public void excluirProprietario(Long id) {
        proprietarioRepository.deleteById(id);
    }

    public Proprietario buscarPorId(Long id) {
        return proprietarioRepository.findById(id).orElse(null);
    }

}
