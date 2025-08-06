package br.com.alura.forumHub.curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Interface para operações de persistência relacionadas à entidade Curso
}