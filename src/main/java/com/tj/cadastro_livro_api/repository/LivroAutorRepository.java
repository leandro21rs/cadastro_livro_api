package com.tj.cadastro_livro_api.repository;

import com.tj.cadastro_livro_api.model.LivroAutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroAutorRepository extends JpaRepository<LivroAutor, Long> {
    void deleteByLivroCod(Long livroCod);
}

