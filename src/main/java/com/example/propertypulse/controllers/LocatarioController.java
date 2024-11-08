package com.example.propertypulse.controllers;

import com.example.propertypulse.model.Locatario;
import com.example.propertypulse.service.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locatarios")
public class LocatarioController {

    @Autowired
    private LocatarioService locatarioService;

    @GetMapping()
    public String hello(){
        return "hello233";
    }

    // Endpoint para salvar um novo locatário
    @PostMapping("/incluir")
    @ResponseStatus(HttpStatus.CREATED)
    public Locatario salvarLocatario(@RequestBody Locatario locatario) {
        return locatarioService.salvarLocatario(locatario);
    }

    // Endpoint para listar todos os locatários
    @GetMapping("/listarlocatarios")
    public List<Locatario> listarLocatarios() {
        return locatarioService.listarLocatarios();
    }
}
