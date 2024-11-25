package com.tj.cadastro_livro_api.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LivroAutorId implements Serializable {

    private Long livro;
    private Long autor;
}
