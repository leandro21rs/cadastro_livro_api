package com.tj.cadastro_livro_api.controller;

import com.tj.cadastro_livro_api.dto.LivroDTO;
import com.tj.cadastro_livro_api.model.Livro;
import com.tj.cadastro_livro_api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(
            @PathVariable Long id,
            @RequestBody LivroDTO livroDTO) {
        Livro livroAtualizado = service.atualizarLivro(id, livroDTO);
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Livro> salvarLivro(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroDTO.getLivro();
        Set<Long> autorIds = livroDTO.getAutorIds();
        Set<Long> assuntoIds = livroDTO.getAssuntoIds();

        try {
            Livro livroSalvo = service.salvarLivro(livro, autorIds, assuntoIds);
            return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

