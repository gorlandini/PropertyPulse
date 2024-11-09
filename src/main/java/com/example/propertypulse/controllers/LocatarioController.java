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

    @GetMapping("/hello")
    public String hello(){
        return "hello2333df";
    }

    // Endpoint para salvar um novo locatário
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Locatario salvarLocatario(@RequestBody Locatario locatario) {
        return locatarioService.salvarLocatario(locatario);
    }

    // Endpoint para listar todos os locatários
    @GetMapping()
    public List<Locatario> listarLocatarios() {
        return locatarioService.listarLocatarios();
    }

    @GetMapping("/{id}")
    public Locatario buscarPorId(@PathVariable Long id) {
        return locatarioService.buscarPorId(id);  // Chama o serviço para buscar o locatário
    }

    // Endpoint para alterar um locatário
    @PutMapping("/{id}")
    public Locatario alterarLocatario(@PathVariable Long id, @RequestBody Locatario locatario) {
        // Atualiza o locatário com o ID fornecido
        locatario.setId(id);  // Garante que o ID do objeto será o mesmo
        return locatarioService.salvarLocatario(locatario); // Reutiliza o método de salvar, já que o PUT é uma atualização
    }

    // Endpoint para excluir um locatário por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Responde com status 204 (sem conteúdo) após a exclusão
    public void excluirLocatario(@PathVariable Long id) {
        locatarioService.excluirLocatario(id); // Chama o método de serviço para excluir o locatário
    }

}
