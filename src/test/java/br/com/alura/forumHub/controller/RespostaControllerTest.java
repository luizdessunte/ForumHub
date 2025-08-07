package br.com.alura.forumHub.controller;

import br.com.alura.forumHub.curso.Curso;
import br.com.alura.forumHub.resposta.DadosCadastroResposta;
import br.com.alura.forumHub.resposta.Resposta;
import br.com.alura.forumHub.resposta.RespostaRepository;
import br.com.alura.forumHub.topico.DadosCadastroTopico;
import br.com.alura.forumHub.topico.Topico;
import br.com.alura.forumHub.topico.TopicoRepository;
import br.com.alura.forumHub.usuario.Usuario;
import br.com.alura.forumHub.usuario.UsuarioRepository;
import br.com.alura.forumHub.usuario.UserRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class RespostaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroResposta> dadosCadastroRespostaJson;

    @MockBean
    private TopicoRepository topicoRepository;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private RespostaRepository respostaRepository;

    @Test
    @DisplayName("Deveria devolver código http 201 ao cadastrar resposta com dados válidos")
    @WithMockUser(username = "user@test.com")
    void cadastrar_cenario1() throws Exception {
        var dadosCadastro = new DadosCadastroResposta("Mensagem de teste", 1L, 1L);
        var autor = new Usuario(1L, "user@test.com", "123", UserRole.USER);
        var curso = new Curso(1L, "Curso Teste", "Categoria Teste");
        var topico = new Topico(new DadosCadastroTopico("Titulo", "Msg", 1L, 1L), autor, curso);
        var respostaSalva = new Resposta(dadosCadastro.mensagem(), topico, autor);

        when(usuarioRepository.findByLogin("user@test.com")).thenReturn(autor);
        when(usuarioRepository.getReferenceById(1L)).thenReturn(autor);
        when(topicoRepository.getReferenceById(1L)).thenReturn(topico);
        when(respostaRepository.save(any(Resposta.class))).thenReturn(respostaSalva);

        var response = mvc.perform(
                post("/respostas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroRespostaJson.write(dadosCadastro).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }
}