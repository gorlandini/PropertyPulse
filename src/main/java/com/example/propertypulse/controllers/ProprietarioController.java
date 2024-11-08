package com.example.propertypulse.controllers;

import com.example.propertypulse.model.Proprietario;
import com.example.propertypulse.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {
    
    @Autowired
    private ProprietarioService proprietarioService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario salvarProprietario(@RequestBody Proprietario proprietario) {
        return proprietarioService.salvarProprietario(proprietario);
    }

    @GetMapping()
    public List<Proprietario> listarProprietarios() {
        return proprietarioService.listarProprietarios();
    }

    @GetMapping("/{id}")
    public Proprietario buscarPorId(@PathVariable Long id) {
        return proprietarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Proprietario alterarProprietario(@PathVariable Long id, @RequestBody Proprietario proprietario) {
        proprietario.setId(id);
        return proprietarioService.salvarProprietario(proprietario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirProprietario(@PathVariable Long id) {
        proprietarioService.excluirProprietario(id);
    }
    
}
