package com.crossmade.pdv.aplicacao.categoria.query.buscar;

import com.crossmade.pdv.aplicacao.categoria.dtos.ListaCategoriaDto;
import com.crossmade.pdv.aplicacao.categoria.mapper.MapperCategoria;
import com.crossmade.pdv.infraestrutura.categoria.CategoriaRepositorioIplm;
import org.springframework.stereotype.Component;

@Component
public class BuscarTodasAsCategoriasHandler {

    private final CategoriaRepositorioIplm repositorio;
    private final MapperCategoria mapper;

    public BuscarTodasAsCategoriasHandler(CategoriaRepositorioIplm repositorio, MapperCategoria mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public ListaCategoriaDto handle(BuscarTodasAsCategoriasQuery query){
        var lista = repositorio.listarTodas();
        return new ListaCategoriaDto(mapper.paraListaDtoVisualizar(lista));
    }
}
