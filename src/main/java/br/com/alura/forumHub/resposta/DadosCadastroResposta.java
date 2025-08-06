package br.com.alura.forumHub.resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroResposta(
        @NotBlank(message = "A mensagem é obrigatória")
        String mensagem,

        @NotNull(message = "O ID do tópico é obrigatório")
        Long idTopico,

        @NotNull(message = "O ID do autor é obrigatório")
        Long idAutor) {
}