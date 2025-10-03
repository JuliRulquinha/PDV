package com.crossmade.pdv.aplicacao.produto.query.por_nome;

import java.util.List;

import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.ListaProdutoDto;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarPorNomeHandler {
    private final ProdutoRepositorioIplm repositorio;

    public BuscarPorNomeHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }
   
    public ListaProdutoDto handle(BuscarPorNomeQuery query){
        var produtos = repositorio.buscarPorNome(query.nome());
        var contagem = repositorio.retornarContagem();
        return new ListaProdutoDto(contagem, produtos);

    }
}
