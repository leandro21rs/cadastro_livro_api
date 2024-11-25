package com.tj.cadastro_livro_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LivroAssuntoId implements Serializable {

    private Long livro;
    private Long assunto;
}
