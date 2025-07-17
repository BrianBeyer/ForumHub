CREATE TABLE topicos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,

    usuario_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,


    resposta_id BIGINT,
    resposta_mensagem TEXT,
    resposta_data_criacao DATETIME,
    resposta_autor VARCHAR(255),
    resposta_solucao TEXT,

    CONSTRAINT fk_topicos_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_topicos_curso FOREIGN KEY (curso_id) REFERENCES cursos(id),

    CONSTRAINT uc_topico_titulo_mensagem UNIQUE (titulo, mensagem)
);
