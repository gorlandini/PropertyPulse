package com.example.propertypulse.controllers;

import com.example.propertypulse.model.Parcela;
import com.example.propertypulse.service.ParcelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcela")
public class ParcelaController {

    private final ParcelaService parcelaService;

    @Autowired
    public ParcelaController(ParcelaService parcelaService) {
        this.parcelaService = parcelaService;
    }

    // Endpoint para salvar uma nova parcela
    @PostMapping
    public ResponseEntity<Parcela> salvarParcela(@RequestBody Parcela parcela) {
        Parcela savedParcela = parcelaService.salvarParcela(parcela);
        return ResponseEntity.ok(savedParcela);
    }

    // Endpoint para listar todas as parcelas
    @GetMapping
    public List<Parcela> listarParcelas() {
        return parcelaService.listarParcelas();
    }

    // Endpoint para buscar parcela por ID
    @GetMapping("/{id}")
    public ResponseEntity<Parcela> buscarParcela(@PathVariable Long id) {
        Optional<Parcela> parcela = parcelaService.buscarParcelaPorId(id);
        return parcela.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para listar parcelas por contrato
    @GetMapping("/contrato/{contratoId}")
    public List<Parcela> listarParcelasPorContrato(@PathVariable Long contratoId) {
        return parcelaService.listarParcelasPorContrato(contratoId);
    }

    // Endpoint para listar parcelas por status
    @GetMapping("/status/{status}")
    public List<Parcela> listarParcelasPorStatus(@PathVariable Boolean status) {
        return parcelaService.listarParcelasPorStatus(status);
    }

    // Endpoint para listar parcelas vencidas
    @GetMapping("/vencidas/{dataVencimento}")
    public List<Parcela> listarParcelasVencidas(@PathVariable String dataVencimento) {
        return parcelaService.listarParcelasVencidas(LocalDate.parse(dataVencimento));
    }
}

