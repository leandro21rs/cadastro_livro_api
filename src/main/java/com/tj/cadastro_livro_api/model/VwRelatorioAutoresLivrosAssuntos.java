package com.tj.cadastro_livro_api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Immutable;

@Entity
@Data
@Table(name = "vw_relatorio_autores_livros_assuntos", schema = "public")
@Immutable
public class VwRelatorioAutoresLivrosAssuntos {

    @Id
    @Column(name = "livro_id")
    private Long livroId;

    @Column(name = "autor_id")
    private Long autorId;

    @Column(name = "autor_nome")
    private String autorNome;

    @Column(name = "livro_titulo")
    private String livroTitulo;

    @Column(name = "livro_editora")
    private String livroEditora;

    @Column(name = "livro_edicao")
    private Integer livroEdicao;

    @Column(name = "livro_ano_publicacao")
    private Integer livroAnoPublicacao;

    @Column(name = "livro_valor")
    private Double livroValor;

    @Column(name = "assunto_id")
    private Long assuntoId;

    @Column(name = "assunto_descricao")
    private String assuntoDescricao;
}
