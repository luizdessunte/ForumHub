package br.com.alura.forumHub.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String autor,
        String curso) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor().getLogin(), // Alterado para obter o login do objeto Usuario
                topico.getCurso().getNome()); // Alterado para obter o nome do objeto Curso
    }
}
