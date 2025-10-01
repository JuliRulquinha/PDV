package com.crossmade.pdv.aplicacao.categoria.query.buscar;

import com.crossmade.pdv.aplicacao.categoria.dtos.ListaCategoriaDto;
import com.crossmade.pdv.infraestrutura.categoria.CategoriaRepositorioIplm;
import org.springframework.stereotype.Component;

@Component
public class BuscarTodasAsCategoriasHandler {

    private final CategoriaRepositorioIplm repositorio;


    public BuscarTodasAsCategoriasHandler(CategoriaRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public ListaCategoriaDto handle(BuscarTodasAsCategoriasQuery query){

        return repositorio.listarTodas();
    }
}
