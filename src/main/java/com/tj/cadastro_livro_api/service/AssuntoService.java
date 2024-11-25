package com.tj.cadastro_livro_api.service;

import com.tj.cadastro_livro_api.model.Assunto;
import com.tj.cadastro_livro_api.repository.AssuntoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuntoService {

    private final AssuntoRepository repository;

    public AssuntoService(AssuntoRepository repository) {
        this.repository = repository;
    }

    public List<Assunto> findAll() {
        return repository.findAll();
    }

    public Assunto findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Assunto não encontrado!"));
    }

    public Assunto save(Assunto assunto) {
        return repository.save(assunto);
    }

    public Assunto update(Long id, Assunto assunto) {
        Assunto existingAssunto = findById(id);
        existingAssunto.setDescricao(assunto.getDescricao());
        return repository.save(existingAssunto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

