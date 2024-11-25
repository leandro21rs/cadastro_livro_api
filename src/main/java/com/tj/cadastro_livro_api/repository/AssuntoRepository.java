package com.tj.cadastro_livro_api.repository;

import com.tj.cadastro_livro_api.model.Assunto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuntoRepository extends JpaRepository<Assunto, Long> {
}

