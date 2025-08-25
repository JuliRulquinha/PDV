package com.crossmade.pdv.aplicacao.produto.query.por_nome;

import java.util.List;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

public class BuscarPorNomeHandler {
    private final ProdutoRepositorioIplm repositorio;

    public BuscarPorNomeHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }
   
    public List<Produto> handle(BuscarPorNomeQuery query){
        return repositorio.buscarPorNome(query.nome());
    }
}
