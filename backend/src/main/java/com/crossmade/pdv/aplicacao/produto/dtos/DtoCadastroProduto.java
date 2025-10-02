package com.crossmade.pdv.aplicacao.produto.dtos;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoria;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import com.crossmade.pdv.dominio.produto.Dimensoes;

import java.math.BigDecimal;
import java.sql.Date;

public record DtoCadastroProduto(
         String nome,
         DtoVisualizarFornecedor fornecedor,
         DtoVisualizarCategoria categoria,
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
