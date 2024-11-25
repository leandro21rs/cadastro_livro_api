package com.tj.cadastro_livro_api.repository;

import com.tj.cadastro_livro_api.model.VwRelatorioAutoresLivrosAssuntos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository extends JpaRepository<VwRelatorioAutoresLivrosAssuntos, Integer> {
}
