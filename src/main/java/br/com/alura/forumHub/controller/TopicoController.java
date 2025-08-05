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
        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            return ResponseEntity.badRequest().body("Tópico duplicado: já existe um tópico com o mesmo título e mensagem.");
        }

        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemTopico(topico));
    }

    // ########## MÉTODO LISTAR ATUALIZADO ##########
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        // A alteração aqui é que, em vez de chamar repository.findAll(),
        // chamamos o nosso novo método repository.findAllByAtivoTrue().
        // Isto garante que a lista devolvida contém apenas os tópicos
        // que estão marcados como ativos no banco de dados.
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = repository.getReferenceById(id);
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    // ########## MÉTODO EXCLUIR ATUALIZADO ##########
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        // 1. Carregamos o tópico do banco de dados.
        var topico = repository.getReferenceById(id);

        // 2. Em vez de chamar repository.deleteById(id), que apaga o registo,
        //    chamamos o nosso novo método topico.excluir().
        //    Este método apenas altera o campo "ativo" para "false".
        topico.excluir();

        // 3. A anotação @Transactional garante que esta alteração será
        //    salva no banco de dados quando o método terminar.
        return ResponseEntity.noContent().build();
    }

}