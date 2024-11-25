-- public.vw_relatorio_autores_livros_assuntos fonte

CREATE OR REPLACE VIEW public.vw_relatorio_autores_livros_assuntos
AS SELECT a.cod_au AS autor_id,
    a.nome AS autor_nome,
    l.cod AS livro_id,
    l.titulo AS livro_titulo,
    l.editora AS livro_editora,
    l.edicao AS livro_edicao,
    l.ano_publicacao AS livro_ano_publicacao,
    l.valor AS livro_valor,
    ass.cod_as AS assunto_id,
    ass.descricao AS assunto_descricao
   FROM livro l
     JOIN livro_autor la ON l.cod = la.livro_cod
     JOIN autor a ON la.autor_cod_au = a.cod_au
     LEFT JOIN livro_assunto lass ON l.cod = lass.livro_cod
     LEFT JOIN assunto ass ON lass.assunto_cod_as = ass.cod_as
  ORDER BY a.nome, l.titulo;