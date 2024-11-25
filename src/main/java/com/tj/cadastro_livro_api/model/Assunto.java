package com.tj.cadastro_livro_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Assunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAs;

    @Column(nullable = false, length = 20)
    private String descricao;
}
