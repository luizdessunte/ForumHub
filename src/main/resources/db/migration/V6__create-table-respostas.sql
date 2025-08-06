CREATE TABLE respostas (
                           id BIGINT NOT NULL AUTO_INCREMENT,
                           mensagem TEXT NOT NULL,
                           data_criacao DATETIME NOT NULL,
                           solucao TINYINT(1) NOT NULL DEFAULT 0,
                           topico_id BIGINT NOT NULL,
                           usuario_id BIGINT NOT NULL,

                           PRIMARY KEY(id),
                           CONSTRAINT fk_respostas_topico_id FOREIGN KEY (topico_id) REFERENCES topicos(id),
                           CONSTRAINT fk_respostas_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);