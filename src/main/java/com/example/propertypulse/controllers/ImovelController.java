package com.example.propertypulse.controllers;

import com.example.propertypulse.model.Imovel;
import com.example.propertypulse.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService ImovelService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Imovel salvarImovel(@RequestBody Imovel imovel) {
        return ImovelService.salvarImovel(imovel);
    }

    @GetMapping()
    public List<Imovel> listarImoveis() {
        return ImovelService.listarImoveis();
    }

    @GetMapping("/{id}")
    public Imovel buscarPorId(@PathVariable Long id) {
        return ImovelService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Imovel alterarImovel(@PathVariable Long id, @RequestBody Imovel imovel) {
        imovel.setId(id);
        return ImovelService.salvarImovel(imovel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirImovel(@PathVariable Long id) {
        ImovelService.excluirImovel(id);
    }

}
