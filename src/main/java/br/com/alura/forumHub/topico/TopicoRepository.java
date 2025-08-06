package br.com.alura.forumHub.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Verifica se já existe um tópico com o mesmo título e mensagem
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

    // Retorna todos os tópicos ativos com paginação
    Page<Topico> findAllByAtivoTrue(Pageable paginacao);
}
