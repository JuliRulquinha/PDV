package com.crossmade.pdv.aplicacao.produto.dtos;

import java.util.List;

public record ListaProdutoDto (
        int contagem,
        List<ModeloVisualizacaoProduto> produtos
){

}
