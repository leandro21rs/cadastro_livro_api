package com.tj.cadastro_livro_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;

    @Column(nullable = false, length = 40)
    private String titulo;

    @Column(nullable = false, length = 40)
    private String editora;

    @Column(nullable = false)
    private Integer edicao;

    @Column(nullable = false, length = 4)
    private String anoPublicacao;

    // Novo campo de valor
    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToMany
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_cod"),
            inverseJoinColumns = @JoinColumn(name = "autor_cod_au")
    )
    private List<Autor> autores;

    @ManyToMany
    @JoinTable(
            name = "livro_assunto",
            joinColumns = @JoinColumn(name = "livro_cod"),
            inverseJoinColumns = @JoinColumn(name = "assunto_cod_as")
    )
    private List<Assunto> assuntos;
}
