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
@IdClass(LivroAssuntoId.class)
public class LivroAssunto {

    @Id
    @ManyToOne
    @JoinColumn(name = "livro_cod", referencedColumnName = "cod")
    private Livro livro;

    @Id
    @ManyToOne
    @JoinColumn(name = "assunto_cod_as", referencedColumnName = "codAs")
    private Assunto assunto;
}
