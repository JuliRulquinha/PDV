package com.crossmade.pdv.aplicacao.produto.dtos;

import java.math.BigDecimal;
import java.sql.Date;

import com.crossmade.pdv.aplicacao.categoria.dtos.ModeloVisualizacaoCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ModeloVisualizacaoFornecedorDentroDeProduto;
import com.crossmade.pdv.dominio.produto.Dimensoes;

public record ModeloVisualizacaoProduto(
        Integer id,
        String nome,
        ModeloVisualizacaoFornecedorDentroDeProduto fornecedor,
        ModeloVisualizacaoCategoriaDentroDeProduto categoria,
        String marca,
        String modelo,
        int quantidade,
        BigDecimal valorCusto,
        BigDecimal valorVenda,
        String imageUrl,
        Date validade,
        Dimensoes dimensoes
) {
}
