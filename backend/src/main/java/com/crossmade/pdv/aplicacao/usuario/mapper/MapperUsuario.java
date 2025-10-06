package com.crossmade.pdv.aplicacao.usuario.mapper;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;
import com.crossmade.pdv.dominio.usuario.Usuario;

@Service
public class MapperUsuario {
    public DtoVisualizarUsuario paraDtoVisualizarUsuario(Usuario usuario){
        return new DtoVisualizarUsuario(usuario.getNome(), usuario.getPapel());
    }
}
