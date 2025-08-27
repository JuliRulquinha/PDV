package com.crossmade.pdv.aplicacao.produto.query.por_categoria;

import java.util.List;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarPorCategoriaHandler {
    private final ProdutoRepositorioIplm repositorio;

    public BuscarPorCategoriaHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }
   
    public List<Produto> handle(BuscarPorCategoriaQuery query){
        return repositorio.buscarPorCategoria(query.categoria());
    }
}
