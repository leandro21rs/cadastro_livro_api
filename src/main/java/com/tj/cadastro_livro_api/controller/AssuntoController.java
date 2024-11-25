package com.tj.cadastro_livro_api.controller;

import com.tj.cadastro_livro_api.model.Assunto;
import com.tj.cadastro_livro_api.service.AssuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assuntos")
public class AssuntoController {


    @Autowired
    private AssuntoService service;

    @GetMapping
    public List<Assunto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assunto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Assunto> save(@RequestBody Assunto assunto) {
        return ResponseEntity.ok(service.save(assunto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assunto> update(@PathVariable Long id, @RequestBody Assunto assunto) {
        return ResponseEntity.ok(service.update(id, assunto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
