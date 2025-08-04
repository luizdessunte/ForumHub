package br.com.alura.forumHub.controller;

import br.com.alura.forumHub.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        // Regra de negócio: Não permitir tópicos duplicados
        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            return ResponseEntity.badRequest().body("Tópico duplicado: já existe um tópico com o mesmo título e mensagem.");
        }

        var topico = new Topico(dados);
        repository.save(topico);

        // Devolve o código 201 Created com o cabeçalho Location e o corpo do novo recurso
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        // Usamos findById que retorna um Optional, ideal para checar se o objeto existe
        var topicoOptional = repository.findById(id);
        if (topicoOptional.isPresent()) {
            // Se o tópico existe, retorna 200 OK com os dados
            return ResponseEntity.ok(new DadosListagemTopico(topicoOptional.get()));
        }
        // Se o Optional estiver vazio, retorna 404 Not Found
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        // Primeiro, verificamos se o tópico realmente existe
        var topicoOptional = repository.findById(id);
        if (topicoOptional.isEmpty()) {
            // Se não existir, retornamos 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // Se existir, pegamos o tópico e o atualizamos
        var topico = topicoOptional.get();
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        // Verifica se o tópico existe antes de tentar deletar
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}