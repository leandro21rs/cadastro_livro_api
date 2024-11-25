package com.tj.cadastro_livro_api.service;

import com.tj.cadastro_livro_api.dto.LivroDTO;
import com.tj.cadastro_livro_api.model.*;
import com.tj.cadastro_livro_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class LivroService {

    @Autowired
    private final LivroRepository repository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AssuntoRepository assuntoRepository;

    @Autowired
    private LivroAutorRepository livroAutorRepository;

    @Autowired
    private LivroAssuntoRepository livroAssuntoRepository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> findAll() {
        return repository.findAll();
    }

    public Livro findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado!"));
    }

    public Livro save(Livro livro) {
        return repository.save(livro);
    }

    @Transactional
    public Livro atualizarLivro(Long livroId, LivroDTO livroDTO) {

        Livro livroExistente = repository.findById(livroId)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));


        livroExistente.setTitulo(livroDTO.getLivro().getTitulo());
        livroExistente.setEditora(livroDTO.getLivro().getEditora());
        livroExistente.setEdicao(livroDTO.getLivro().getEdicao());
        livroExistente.setAnoPublicacao(livroDTO.getLivro().getAnoPublicacao());
        livroExistente.setValor(livroDTO.getLivro().getValor());


        repository.save(livroExistente);


        atualizarAutores(livroExistente, livroDTO.getAutorIds());


        atualizarAssuntos(livroExistente, livroDTO.getAssuntoIds());

        return livroExistente;
    }

    private void atualizarAutores(Livro livro, Set<Long> autorIds) {

        livroAutorRepository.deleteByLivroCod(livro.getCod());


        for (Long autorId : autorIds) {
            Autor autor = autorRepository.findById(autorId)
                    .orElseThrow(() -> new IllegalArgumentException("Autor não encontrado"));

            var livroAutor = LivroAutor.builder().autor(autor).livro(livro).build();

            livroAutorRepository.save(livroAutor);
        }
    }

    private void atualizarAssuntos(Livro livro, Set<Long> assuntoIds) {

        livroAssuntoRepository.deleteByLivroCod(livro.getCod());


        for (Long assuntoId : assuntoIds) {
            Assunto assunto = assuntoRepository.findById(assuntoId)
                    .orElseThrow(() -> new IllegalArgumentException("Assunto não encontrado"));

            var livroAssunto = LivroAssunto.builder().livro(livro).assunto(assunto).build();

            livroAssuntoRepository.save(livroAssunto);
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Livro salvarLivro(Livro livro, Set<Long> autorIds, Set<Long> assuntoIds) {

        List<Autor> autores = autorRepository.findAllById(autorIds);
        if (autores.size() != autorIds.size()) {
            throw new IllegalArgumentException("Alguns autores não foram encontrados.");
        }


        List<Assunto> assuntos = assuntoRepository.findAllById(assuntoIds);
        if (assuntos.size() != assuntoIds.size()) {
            throw new IllegalArgumentException("Alguns assuntos não foram encontrados.");
        }


        livro.setAutores(autores);
        livro.setAssuntos(assuntos);


        return repository.save(livro);
    }
}

