package com.example.propertypulse.controllers;

import com.example.propertypulse.model.Contrato;
import com.example.propertypulse.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Contrato salvarContrato(@RequestBody Contrato contrato) {
        return contratoService.salvarContrato(contrato);
    }

    @GetMapping()
    public List<Contrato> listarContratos() {
        return contratoService.listarContratos();
    }

    @GetMapping("/{id}")
    public Contrato buscarPorId(@PathVariable Long id) {
        return contratoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Contrato alterarContrato(@PathVariable Long id, @RequestBody Contrato contrato) {
        contrato.setId(id);
        return contratoService.salvarContrato(contrato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirContrato(@PathVariable Long id) {
        contratoService.excluirContrato(id);
    }

}
