package com.tj.cadastro_livro_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(LivroAutorId.class)
public class LivroAutor {

    @Id
    @ManyToOne
    @JoinColumn(name = "livro_cod", referencedColumnName = "cod")
    private Livro livro;

    @Id
    @ManyToOne
    @JoinColumn(name = "autor_cod_au", referencedColumnName = "codAu")
    private Autor autor;
}
