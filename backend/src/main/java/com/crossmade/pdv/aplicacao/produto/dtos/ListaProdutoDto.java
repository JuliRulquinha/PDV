package com.crossmade.pdv.aplicacao.produto.dtos;

import com.crossmade.pdv.dominio.produto.Produto;

import java.util.List;

public record ListaProdutoDto (
        int contagem,
        List<DtoVisualizarProduto> produtos
){

}
