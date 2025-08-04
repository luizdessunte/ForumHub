package br.com.alura.forumHub.topico;

// Não precisamos de validações como @NotBlank aqui, pois os campos são opcionais.
public record DadosAtualizacaoTopico(
        String titulo,
        String mensagem,
        String status,
        String autor,
        String curso) {
}
