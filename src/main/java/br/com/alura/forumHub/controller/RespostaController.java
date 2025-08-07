package br.com.alura.forumHub.controller;

import br.com.alura.forumHub.resposta.*;
import br.com.alura.forumHub.topico.TopicoRepository;
import br.com.alura.forumHub.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroResposta dados, UriComponentsBuilder uriBuilder) {
        var topico = topicoRepository.getReferenceById(dados.idTopico());
        var autor = usuarioRepository.getReferenceById(dados.idAutor());

        var resposta = new Resposta(dados.mensagem(), topico, autor);
        repository.save(resposta);

        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemResposta(resposta));
    }

    @GetMapping("/topico/{idTopico}")
    public ResponseEntity<List<DadosListagemResposta>> listarPorTopico(@PathVariable Long idTopico) {
        var respostas = repository.findAllByTopicoId(idTopico);
        var listagem = respostas.stream().map(DadosListagemResposta::new).toList();
        return ResponseEntity.ok(listagem);
    }

    // --- MÉTODO DE ATUALIZAÇÃO ---
    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN') or @securityService.isAutorDaResposta(authentication, #id)")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoResposta dados) {
        var resposta = repository.getReferenceById(id);
        resposta.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemResposta(resposta));
    }

    // --- MÉTODO DE EXCLUSÃO ---
    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN') or @securityService.isAutorDaResposta(authentication, #id)")
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}