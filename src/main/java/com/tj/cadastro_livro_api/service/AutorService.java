package com.tj.cadastro_livro_api.service;

import com.tj.cadastro_livro_api.model.Autor;
import com.tj.cadastro_livro_api.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> findAll() {
        return repository.findAll();
    }

    public Autor findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado!"));
    }

    public Autor save(Autor autor) {
        return repository.save(autor);
    }

    public Autor update(Long id, Autor autor) {
        Autor existingAutor = findById(id);
        existingAutor.setNome(autor.getNome());
        return repository.save(existingAutor);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

