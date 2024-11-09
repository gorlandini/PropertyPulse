package com.example.propertypulse.service;

import com.example.propertypulse.model.Imovel;
import com.example.propertypulse.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository ImovelRepository;

    public Imovel salvarImovel(Imovel imovel) {
        return ImovelRepository.save(imovel);
    }

    public List<Imovel> listarImoveis() {
        return ImovelRepository.findAll();
    }

    public Optional<Imovel> buscarImovelPorId(Long id) {
        return ImovelRepository.findById(id);
    }

    public void excluirImovel(Long id) {
        ImovelRepository.deleteById(id);
    }

    public Imovel buscarPorId(Long id) {
        return ImovelRepository.findById(id).orElse(null);
    }

}
