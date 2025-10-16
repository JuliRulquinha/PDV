package com.crossmade.pdv.aplicacao.orcamento.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;

public record ModeloVisualizacaoOrcamento(
    Integer id,
    List<ModeloVisualizacaoProduto> produtos,
    ModeloVisualizacaoCliente cliente,
    Date validade,
    BigDecimal total,
    int desconto
) {}
