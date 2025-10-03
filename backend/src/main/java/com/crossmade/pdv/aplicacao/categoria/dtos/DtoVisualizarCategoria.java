package com.crossmade.pdv.aplicacao.categoria.dtos;

import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;

import java.util.List;

public record DtoVisualizarCategoria(
        String nome,
        String descricao,
        List<DtoVisualizarProduto> produtos
) {
}
