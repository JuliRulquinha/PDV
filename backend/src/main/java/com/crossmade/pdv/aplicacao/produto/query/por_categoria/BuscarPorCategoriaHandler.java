package com.crossmade.pdv.aplicacao.produto.query.por_categoria;

import com.crossmade.pdv.aplicacao.produto.dtos.ListaProdutoDto;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarPorCategoriaHandler {
    private final ProdutoRepositorioIplm repositorio;
    private final MapperProduto mapper;

    public BuscarPorCategoriaHandler(ProdutoRepositorioIplm repositorio, MapperProduto mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }
   
    public ListaProdutoDto handle(BuscarPorCategoriaQuery query){
        var produtos = repositorio.buscarPorCategoria(query.categoria());
        var contagem = repositorio.retornarContagem();
        return new ListaProdutoDto(contagem, mapper.paraListaDtoDeVisualizar(produtos));
    }
}
