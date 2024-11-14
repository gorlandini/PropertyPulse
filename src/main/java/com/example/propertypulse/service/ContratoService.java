package com.example.propertypulse.service;

import com.example.propertypulse.model.Contrato;
import com.example.propertypulse.model.Parcela;
import com.example.propertypulse.repository.ContratoRepository;
import com.example.propertypulse.repository.ParcelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ParcelaRepository parcelaRepository;

    public Contrato salvarContrato(Contrato contrato) {
      //  System.out.println("Valor mensal:" + contrato.getValorMensal());

        Contrato contratoSalvo = contratoRepository.save(contrato);

        // Após salvar o contrato, gera as parcelas
        gerarParcelas(contratoSalvo);
        
        
        return contratoSalvo;
    }

    private void gerarParcelas(Contrato contrato) {

        List<Parcela> parcelas = new ArrayList<>();

        // Determinar o número de meses entre a data de início e a data de término
        LocalDate dataInicio = contrato.getDataInicio();
        LocalDate dataTermino = contrato.getDataTermino();
        BigDecimal valorMensal = contrato.getValorMensal();

        // Supondo que as parcelas são mensais
        LocalDate dataVencimento = dataInicio.plusMonths(1); // Primeira parcela é um mês após a data de início
        while (!dataVencimento.isAfter(dataTermino)) {
            Parcela parcela = new Parcela();
            parcela.setValorParcela(valorMensal);
            parcela.setDataInicio(dataInicio);
            parcela.setDataVencimento(dataVencimento);
            parcela.setAtiva(true);
            parcela.setContrato(contrato);

            parcelas.add(parcela);

            // Avançar para o próximo mês
            dataVencimento = dataVencimento.plusMonths(1);
        }

        // Salvar as parcelas no banco de dados
        parcelaRepository.saveAll(parcelas);


    }

    public List<Contrato> buscarContratosPorNomeLocatario(String nomeLocatario) {
        return contratoRepository.findByLocatarioNome(nomeLocatario);
    }

    public List<Contrato> listarContratos() {
        return contratoRepository.findAll();
    }

    public Optional<Contrato> buscarContratoPorId(Long id) {
        return contratoRepository.findById(id);
    }

    public void excluirContrato(Long id) {
        contratoRepository.deleteById(id);
    }

    public Contrato buscarPorId(Long id) {
        return contratoRepository.findById(id).orElse(null);
    }

}
