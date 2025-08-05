ALTER TABLE topicos ADD COLUMN usuario_id BIGINT;
ALTER TABLE topicos ADD COLUMN curso_id BIGINT;

ALTER TABLE topicos ADD CONSTRAINT fk_topicos_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id);
ALTER TABLE topicos ADD CONSTRAINT fk_topicos_curso_id FOREIGN KEY (curso_id) REFERENCES cursos(id);

ALTER TABLE topicos DROP COLUMN autor;
ALTER TABLE topicos DROP COLUMN curso;