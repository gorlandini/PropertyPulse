package com.example.propertypulse.service;

import com.example.propertypulse.model.Endereco;
import com.example.propertypulse.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public void excluirEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public Endereco buscaPorId(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

}
