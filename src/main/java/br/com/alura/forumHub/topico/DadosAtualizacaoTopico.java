package br.com.alura.forumHub.topico;

public record DadosAtualizacaoTopico(
        String titulo,
        String mensagem,
        String status,
        Long idCurso) {
}