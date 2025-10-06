package com.crossmade.pdv.aplicacao.categoria.command.cadastrar;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoria;
import com.crossmade.pdv.aplicacao.categoria.mapper.MapperCategoria;
import com.crossmade.pdv.dominio.categoria.Categoria;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.infraestrutura.categoria.CategoriaRepositorioIplm;

@Component
public class CadastrarCategoriaHandler {
    private final CategoriaRepositorioIplm repositorio;
    private final MapperCategoria mapper;

    public CadastrarCategoriaHandler (CategoriaRepositorioIplm repositorio, MapperCategoria mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public DtoVisualizarCategoria handle(CadastrarCategoriaCommand command){
        Categoria categoria = new Categoria(command.nome(), command.descricao());
        var salva = repositorio.salvar(categoria);
        return mapper.paraDtoDeVisualizar(salva);
    }
}
