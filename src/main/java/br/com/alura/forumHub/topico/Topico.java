package br.com.alura.forumHub.topico;

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
    private String autor;
    private String curso;

    // 1. NOVO ATRIBUTO ADICIONADO AQUI
    private Boolean ativo;

    // Construtor que recebe o DTO de cadastro
    public Topico(DadosCadastroTopico dados) {
        // 2. LINHA NOVA ADICIONADA AO CONSTRUTOR
        this.ativo = true; // Todo novo tópico começa como ativo
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.status = "NAO_RESPONDIDO"; // Status inicial padrão
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }
        if (dados.curso() != null) {
            this.curso = dados.curso();
        }
    }

    // 3. NOVO MÉTODO ADICIONADO AQUI (para a exclusão lógica)
    public void excluir() {
        this.ativo = false;
    }
}