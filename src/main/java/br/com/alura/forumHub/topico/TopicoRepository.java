package br.com.alura.forumHub.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Método que já tínhamos para a regra de negócio de não duplicidade
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

    // ########## NOVO MÉTODO ADICIONADO ##########
    // Este é um método de consulta derivado (derived query method).
    // Apenas por escrever o nome do método seguindo as convenções do Spring Data JPA,
    // ele automaticamente gera a consulta SQL correspondente:
    // "SELECT * FROM topicos WHERE ativo = true" com paginação.
    Page<Topico> findAllByAtivoTrue(Pageable paginacao);

}
