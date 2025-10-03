package com.crossmade.pdv.aplicacao.produto.query.por_categoria;

import java.util.List;

import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.ListaProdutoDto;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarPorCategoriaHandler {
    private final ProdutoRepositorioIplm repositorio;

    public BuscarPorCategoriaHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }
   
    public ListaProdutoDto handle(BuscarPorCategoriaQuery query){
        var produtos = repositorio.buscarPorCategoria(query.categoria());
        var contagem = repositorio.retornarContagem();
        return new ListaProdutoDto(contagem, produtos);
    }
}
