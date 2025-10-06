package com.crossmade.pdv.aplicacao.usuario.servicos;

import com.crossmade.pdv.dominio.usuario.UsuarioRepositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    private final UsuarioRepositorio usuarioRepositorio;

    public AutenticacaoService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            var usuario = usuarioRepositorio.buscarPorNome(username);

            if (usuario == null) {
                throw new UsernameNotFoundException("Usuário não encontrado: " + username);
            }

            return usuario;

        } catch (UsernameNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new UsernameNotFoundException("Erro ao buscar o usuário: " + username, e);
        }
    }
}
