-- Tabela autor
CREATE TABLE autor (
    cod_au SERIAL PRIMARY KEY,
    nome VARCHAR(40) NOT NULL
);

-- Índices adicionais para a tabela autor
CREATE INDEX idx_autor_nome ON autor (nome);

-- Tabela livro
CREATE TABLE livro (
    cod SERIAL PRIMARY KEY,
    titulo VARCHAR(40) NOT NULL,
    editora VARCHAR(40) NOT NULL,
    edicao INTEGER NOT NULL,
    ano_publicacao VARCHAR(4) NOT NULL
);

-- Índices adicionais para a tabela livro
CREATE INDEX idx_livro_titulo ON livro (titulo);

-- Tabela assunto
CREATE TABLE assunto (
    cod_as SERIAL PRIMARY KEY,
    descricao VARCHAR(20) NOT NULL
);

-- Índices adicionais para a tabela assunto
CREATE INDEX idx_assunto_descricao ON assunto (descricao);

-- Tabela livro_autor (Relacionamento muitos-para-muitos entre livro e autor)
CREATE TABLE livro_autor (
    livro_cod INTEGER NOT NULL,
    autor_cod_au INTEGER NOT NULL,
    PRIMARY KEY (livro_cod, autor_cod_au),
    FOREIGN KEY (livro_cod) REFERENCES livro (cod) ON DELETE CASCADE,
    FOREIGN KEY (autor_cod_au) REFERENCES autor (cod_au) ON DELETE CASCADE
);

-- Índices adicionais para a tabela livro_autor
CREATE INDEX idx_livro_autor_livro ON livro_autor (livro_cod);
CREATE INDEX idx_livro_autor_autor ON livro_autor (autor_cod_au);

-- Tabela livro_assunto (Relacionamento muitos-para-muitos entre livro e assunto)
CREATE TABLE livro_assunto (
    livro_cod INTEGER NOT NULL,
    assunto_cod_as INTEGER NOT NULL,
    PRIMARY KEY (livro_cod, assunto_cod_as),
    FOREIGN KEY (livro_cod) REFERENCES livro (cod) ON DELETE CASCADE,
    FOREIGN KEY (assunto_cod_as) REFERENCES assunto (cod_as) ON DELETE CASCADE
);

-- Índices adicionais para a tabela livro_assunto
CREATE INDEX idx_livro_assunto_livro ON livro_assunto (livro_cod);
CREATE INDEX idx_livro_assunto_assunto ON livro_assunto (assunto_cod_as);
