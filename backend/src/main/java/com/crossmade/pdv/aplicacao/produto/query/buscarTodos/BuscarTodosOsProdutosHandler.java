package com.crossmade.pdv.aplicacao.produto.query.buscarTodos;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.produto.dtos.ListaProdutoDto;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarTodosOsProdutosHandler {

    private final ProdutoRepositorioIplm repositorio;
    private final MapperProduto mapper;

    public BuscarTodosOsProdutosHandler(ProdutoRepositorioIplm repositorio, MapperProduto mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public ListaProdutoDto handle(BuscarTodosOsProdutosQuery query){
        var produtos = repositorio.listarTodos(query.pagina());
        var contagem = repositorio.retornarContagem();
        return new ListaProdutoDto(contagem, mapper.paraListaDtoDeVisualizar(produtos));
    }
}
