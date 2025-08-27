package com.crossmade.pdv.aplicacao.produto.query.buscarTodos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarTodosOsProdutosHandler {

    private final ProdutoRepositorioIplm repositorio;

    public BuscarTodosOsProdutosHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public List<Produto> handle(BuscarTodosOsProdutosQuery query){
        return repositorio.buscarTodos();
    }
}
