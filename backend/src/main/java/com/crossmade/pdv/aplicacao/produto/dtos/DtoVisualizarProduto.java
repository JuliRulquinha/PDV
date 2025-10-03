package com.crossmade.pdv.aplicacao.produto.dtos;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedorDentroDeProduto;
import com.crossmade.pdv.dominio.produto.Dimensoes;

import java.math.BigDecimal;
import java.sql.Date;

public record DtoVisualizarProduto(
        String nome,
        DtoVisualizarFornecedorDentroDeProduto fornecedor,
        DtoVisualizarCategoriaDentroDeProduto categoria,
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
