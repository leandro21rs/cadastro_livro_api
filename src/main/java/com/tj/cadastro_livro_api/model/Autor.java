package com.tj.cadastro_livro_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAu;

    @Column(nullable = false, length = 40)
    private String nome;
}
