package com.tj.cadastro_livro_api.service;

import com.tj.cadastro_livro_api.model.VwRelatorioAutoresLivrosAssuntos;
import com.tj.cadastro_livro_api.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public List<VwRelatorioAutoresLivrosAssuntos> buscarRelatorio() {
        return relatorioRepository.findAll();
    }
}

