package com.tj.cadastro_livro_api.repository;


import com.tj.cadastro_livro_api.model.LivroAssunto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroAssuntoRepository extends JpaRepository<LivroAssunto, Long> {
    void deleteByLivroCod(Long livroCod);
}
