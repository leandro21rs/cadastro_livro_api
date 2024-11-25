package com.tj.cadastro_livro_api.repository;

import com.tj.cadastro_livro_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}

