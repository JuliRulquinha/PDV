package com.crossmade.pdv.aplicacao.usuario.command.cadastrar;

import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;
import com.crossmade.pdv.aplicacao.usuario.mapper.MapperUsuario;
import com.crossmade.pdv.dominio.usuario.Usuario;
import com.crossmade.pdv.infraestrutura.usuario.RepositorioUsuarioImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CadastrarUsuarioHandler {

    private final RepositorioUsuarioImpl repositorio;
    private final MapperUsuario mapper;
    private final PasswordEncoder passwordEncoder;

    public CadastrarUsuarioHandler(RepositorioUsuarioImpl repositorio, MapperUsuario mapper, PasswordEncoder passwordEncoder) {
        this.repositorio = repositorio;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public DtoVisualizarUsuario handle(CadastrarUsuarioCommand command) {
        var senhaCriptografada = passwordEncoder.encode(command.senha());
        var usuario = new Usuario(command.nome(), senhaCriptografada, command.papel());
        var salvo = repositorio.salvar(usuario);
        return mapper.paraDtoVisualizarUsuario(salvo);
    }
}
