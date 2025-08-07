package br.com.alura.forumHub.infra.security;

import br.com.alura.forumHub.resposta.RespostaRepository;
import br.com.alura.forumHub.topico.TopicoRepository;
import br.com.alura.forumHub.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service("securityService")
public class SecurityService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    public boolean isAutorDoTopico(Authentication authentication, Long topicoId) {
        var topico = topicoRepository.findById(topicoId).orElse(null);
        if (topico == null) {
            return false;
        }
        Usuario usuarioAutenticado = (Usuario) authentication.getPrincipal();
        return topico.getAutor().getId().equals(usuarioAutenticado.getId());
    }

    public boolean isAutorDaResposta(Authentication authentication, Long respostaId) {
        var resposta = respostaRepository.findById(respostaId).orElse(null);
        if (resposta == null) {
            return false;
        }
        Usuario usuarioAutenticado = (Usuario) authentication.getPrincipal();
        return resposta.getAutor().getId().equals(usuarioAutenticado.getId());
    }
}