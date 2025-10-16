package com.crossmade.pdv.aplicacao.categoria.dtos;

import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;

import java.util.List;

public record DtoVisualizarCategoria(
        String nome,
        String descricao,
        List<ModeloVisualizacaoProduto> produtos
) {
}
