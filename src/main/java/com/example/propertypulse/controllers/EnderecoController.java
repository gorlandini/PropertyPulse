package com.example.propertypulse.controllers;

import com.example.propertypulse.model.Endereco;
import com.example.propertypulse.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.salvarEndereco(endereco);
    }

    @GetMapping()
    public List<Endereco> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable Long id) {
        return enderecoService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    public Endereco alterarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        endereco.setId(id);
        return enderecoService.salvarEndereco(endereco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEndereco(@PathVariable Long id) {
        enderecoService.excluirEndereco(id);
    }

}
