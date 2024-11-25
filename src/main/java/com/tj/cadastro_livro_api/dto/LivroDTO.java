package com.tj.cadastro_livro_api.dto;

import com.tj.cadastro_livro_api.model.Livro;
import lombok.Data;

import java.util.Set;

@Data
public class LivroDTO {
    private Livro livro;
    private Set<Long> autorIds;
    private Set<Long> assuntoIds;
}
