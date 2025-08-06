package br.com.alura.forumHub.controller;

import br.com.alura.forumHub.usuario.DadosRegistroUsuario;
import br.com.alura.forumHub.usuario.Usuario;
import br.com.alura.forumHub.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DadosRegistroUsuario dados) {
        // Verifica se o login já existe no banco de dados
        if (repository.findByLogin(dados.login()) != null) {
            return ResponseEntity.badRequest().body("Erro: O login informado já está em uso.");
        }

        // Criptografa a senha antes de salvar o usuário
        var senhaCriptografada = passwordEncoder.encode(dados.senha());
        var usuario = new Usuario(null, dados.login(), senhaCriptografada);
        repository.save(usuario);

        // Retorna uma mensagem de sucesso após o registro
        return ResponseEntity.ok().body("Sucesso: Utilizador registado com sucesso!");
    }
}