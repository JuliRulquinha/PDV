package com.crossmade.pdv.aplicacao.categoria.dtos;

import java.util.List;

import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;

public record DtoVisualizarCategoria(
        Integer id,
        String nome,
        String descricao,
        List<ModeloVisualizacaoProduto> produtos
) {
}
