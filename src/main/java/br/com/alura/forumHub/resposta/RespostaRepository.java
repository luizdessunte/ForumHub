package br.com.alura.forumHub.resposta;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // Importe a classe List

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    // Novo método para buscar todas as respostas de um tópico específico
    List<Resposta> findAllByTopicoId(Long idTopico);
}