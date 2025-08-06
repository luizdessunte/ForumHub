package br.com.alura.forumHub.resposta;

import java.time.LocalDateTime;

public record DadosListagemResposta(
        Long id,
        String mensagem,
        LocalDateTime dataCriacao,
        Boolean solucao,
        String autor) {

    public DadosListagemResposta(Resposta resposta) {
        this(resposta.getId(),
                resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getSolucao(),
                resposta.getAutor().getLogin());
    }
}