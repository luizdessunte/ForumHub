package br.com.alura.forumHub.controller;

import br.com.alura.forumHub.curso.CursoRepository;
import br.com.alura.forumHub.topico.*;
import br.com.alura.forumHub.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    //Método Cadastrar

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        // Obtém o autor e o curso a partir dos IDs fornecidos
        var autor = usuarioRepository.getReferenceById(dados.idAutor());
        var curso = cursoRepository.getReferenceById(dados.idCurso());

        // Cria e salva um novo tópico
        var topico = new Topico(dados, autor, curso);
        repository.save(topico);

        // Retorna a URI do recurso criado
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemTopico(topico));
    }

    // Método Listar

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        // Lista todos os tópicos ativos com paginação
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    //Método Detalhar

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        // Detalha um tópico específico pelo ID
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    // Método Atualizar
    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN') or @securityService.isAutorDoTopico(authentication, #id)")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        // Atualiza as informações de um tópico existente
        var topico = repository.getReferenceById(id);
        var curso = dados.idCurso() != null ? cursoRepository.getReferenceById(dados.idCurso()) : null;
        topico.atualizarInformacoes(dados, curso);

        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    // Método Excluir
    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN') or @securityService.isAutorDoTopico(authentication, #id)")

    public ResponseEntity excluir(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        topico.excluir();

        return ResponseEntity.noContent().build();
    }
}
