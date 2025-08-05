package br.com.alura.forumHub.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosRegistroUsuario(
        @NotBlank
        @Email
        String login,

        @NotBlank
        String senha) {
}
