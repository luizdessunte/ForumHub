package br.com.alura.forumHub.resposta;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoResposta(
        @NotBlank(message = "A mensagem não pode estar em branco")
        String mensagem,
        Boolean solucao) {
}
