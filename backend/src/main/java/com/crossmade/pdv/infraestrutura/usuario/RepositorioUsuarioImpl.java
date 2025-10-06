package com.crossmade.pdv.infraestrutura.usuario;

import com.crossmade.pdv.aplicacao.usuario.dtos.DtoCadastrarUsuario;
import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;
import com.crossmade.pdv.aplicacao.usuario.mapper.MapperUsuario;
import com.crossmade.pdv.dominio.usuario.UsuarioRepositorio;

public class RepositorioUsuarioImpl implements UsuarioRepositorio {


    private final SpringDataRepositorioUsuario repositorio;
    private final MapperUsuario mapper;


    public RepositorioUsuarioImpl(SpringDataRepositorioUsuario repositorio, com.crossmade.pdv.aplicacao.usuario.mapper.MapperUsuario mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public DtoVisualizarUsuario salvar(DtoCadastrarUsuario usuario) {
        var salvo = repositorio.save(mapper.paraUsuario(usuario));
        return mapper.paraDtoVisualizarUsuario(salvo);
    }

    @Override
    public DtoVisualizarUsuario buscarPorId(Integer id) {
        var usuarioDoDb = repositorio.findById(id).orElseThrow();
        return mapper.paraDtoVisualizarUsuario(usuarioDoDb);
    }

    @Override
    public void deletar(Integer id) {
       repositorio.deleteById(id);
    }

}


