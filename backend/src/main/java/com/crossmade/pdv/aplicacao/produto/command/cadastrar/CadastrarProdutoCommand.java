package com.crossmade.pdv.aplicacao.produto.command.cadastrar;

import java.math.BigDecimal;
import java.sql.Date;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedorDentroDeProduto;
import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.produto.Dimensoes;

public record CadastrarProdutoCommand (
    String nome,
    Categoria categoria,
    Fornecedor fornecedor,
    String marca,
    String modelo,
    int quantidade,
    BigDecimal valorCusto,
    BigDecimal valorVenda,
    String imageUrl,
    Date validade,
    Dimensoes dimensoes
)   {}


