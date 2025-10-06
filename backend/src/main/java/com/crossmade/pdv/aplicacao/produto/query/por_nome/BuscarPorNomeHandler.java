package com.crossmade.pdv.aplicacao.produto.query.por_nome;

import com.crossmade.pdv.aplicacao.produto.dtos.ListaProdutoDto;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarPorNomeHandler {
    private final ProdutoRepositorioIplm repositorio;
    private final MapperProduto mapper;

    public BuscarPorNomeHandler(ProdutoRepositorioIplm repositorio, MapperProduto mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }
   
    public ListaProdutoDto handle(BuscarPorNomeQuery query){
        var produtos = repositorio.buscarPorNome(query.nome());
        var contagem = repositorio.retornarContagem();
        return new ListaProdutoDto(contagem, mapper.paraListaDtoDeVisualizar(produtos));

    }
}
