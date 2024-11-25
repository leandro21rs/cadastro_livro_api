package com.tj.cadastro_livro_api.repository;

import com.tj.cadastro_livro_api.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
