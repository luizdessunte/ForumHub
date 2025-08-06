package br.com.alura.forumHub.topico;

import br.com.alura.forumHub.curso.Curso;
import br.com.alura.forumHub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private Boolean ativo;

    public Topico(DadosCadastroTopico dados, Usuario autor, Curso curso) {
        // Construtor utilizado para criar um novo tópico a partir dos dados recebidos.
        this.ativo = true;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = autor;
        this.curso = curso;
        this.status = "NAO_RESPONDIDO";
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados, Curso curso) {
        // Atualiza apenas os campos informados no DTO.
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
        if (curso != null) {
            this.curso = curso;
        }
    }

    public void excluir() {
        // Exclusão lógica do tópico.
        this.ativo = false;
    }
}