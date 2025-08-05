package br.com.alura.forumHub.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Diz ao Spring para retornar 404 por padrão
public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String message) {
        super(message); // Passa a mensagem para a classe pai (RuntimeException)
    }
}