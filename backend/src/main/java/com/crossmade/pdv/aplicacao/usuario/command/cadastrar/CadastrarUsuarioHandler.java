package com.crossmade.pdv.aplicacao.usuario.command.cadastrar;

import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;
import com.crossmade.pdv.aplicacao.usuario.mapper.MapperUsuario;
import com.crossmade.pdv.dominio.usuario.Usuario;
import com.crossmade.pdv.infraestrutura.usuario.RepositorioUsuarioImpl;
import org.springframework.stereotype.Component;

@Component
public class CadastrarUsuarioHandler {

    private final RepositorioUsuarioImpl repositorio;
    private final MapperUsuario mapper;

    public CadastrarUsuarioHandler(RepositorioUsuarioImpl repositorio, MapperUsuario mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public DtoVisualizarUsuario handle(CadastrarUsuarioCommand command){
        var salvo = repositorio.salvar(new Usuario(command.nome(), command.senha(), command.papel()));
        return mapper.paraDtoVisualizarUsuario(salvo);
   }
}
