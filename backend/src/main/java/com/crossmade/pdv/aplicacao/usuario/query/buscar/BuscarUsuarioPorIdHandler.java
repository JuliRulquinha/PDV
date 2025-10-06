package com.crossmade.pdv.aplicacao.usuario.query.buscar;

import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;
import com.crossmade.pdv.aplicacao.usuario.mapper.MapperUsuario;
import com.crossmade.pdv.infraestrutura.usuario.RepositorioUsuarioImpl;
import org.springframework.stereotype.Component;

@Component
public class BuscarUsuarioPorIdHandler {

    private final RepositorioUsuarioImpl repositorio;
    private final MapperUsuario mapper;

    public BuscarUsuarioPorIdHandler(RepositorioUsuarioImpl repositorio, MapperUsuario mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public DtoVisualizarUsuario handle(BuscarUsuarioPorIdQuery query){
        var usuarioDoDb = repositorio.buscarPorId(query.id());
        return mapper.paraDtoVisualizarUsuario(usuarioDoDb);
    }

}
