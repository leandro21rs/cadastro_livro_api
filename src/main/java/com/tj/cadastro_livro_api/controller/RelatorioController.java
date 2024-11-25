package com.tj.cadastro_livro_api.controller;

import com.tj.cadastro_livro_api.model.VwRelatorioAutoresLivrosAssuntos;
import com.tj.cadastro_livro_api.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping
    public ResponseEntity<List<VwRelatorioAutoresLivrosAssuntos>> gerarRelatorio() {
        List<VwRelatorioAutoresLivrosAssuntos> relatorio = relatorioService.buscarRelatorio();
        return ResponseEntity.ok(relatorio);
    }
}
