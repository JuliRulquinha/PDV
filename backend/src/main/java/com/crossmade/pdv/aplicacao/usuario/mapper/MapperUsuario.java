package com.crossmade.pdv.aplicacao.usuario.mapper;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.usuario.dtos.DtoCadastrarUsuario;
import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;
import com.crossmade.pdv.dominio.usuario.Usuario;

@Service
public class MapperUsuario {

    public Usuario paraUsuario(DtoCadastrarUsuario dto){
        return new Usuario(dto.nome(), dto.senha(), dto.papel());
    }

    public DtoVisualizarUsuario paraDtoVisualizarUsuario(Usuario usuario){
        return new DtoVisualizarUsuario(usuario.getNome(), usuario.getPapel());
    }
}
