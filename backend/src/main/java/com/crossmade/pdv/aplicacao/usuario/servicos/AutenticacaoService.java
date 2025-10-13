package com.crossmade.pdv.aplicacao.usuario.servicos;

import com.crossmade.pdv.dominio.usuario.UsuarioRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    private final UsuarioRepositorio usuarioRepositorio;
    private static final Logger log = LoggerFactory.getLogger(AutenticacaoService.class);

    public AutenticacaoService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            var usuario = usuarioRepositorio.buscarPorNome(username);

            if (usuario == null) {
                log.error("Usuário não encontrado: " + username);
                throw new UsernameNotFoundException("Usuário não encontrado: " + username);
            }
            log.info("Usuário logado com sucesso: " + username);
            return usuario;

        } catch (UsernameNotFoundException e) {

            throw e;

        } catch (Exception e) {

            log.error("Erro ao buscar o usuário: " + username);
            throw new UsernameNotFoundException("Erro ao buscar o usuário: " + username, e);
        }
    }
}
