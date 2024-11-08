package com.example.propertypulse.service;

import com.example.propertypulse.model.Locatario;
import com.example.propertypulse.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocatarioService {

    @Autowired
    private LocatarioRepository locatarioRepository;

    // Método para salvar um locatário
    public Locatario salvarLocatario(Locatario locatario) {
        return locatarioRepository.save(locatario);
    }

    // Método para listar todos os locatários
    public List<Locatario> listarLocatarios() {
        return locatarioRepository.findAll();
    }

    // Método para buscar um locatário pelo ID (opcional)
    public Optional<Locatario> buscarLocatarioPorId(Long id) {
        return locatarioRepository.findById(id);
    }
}

