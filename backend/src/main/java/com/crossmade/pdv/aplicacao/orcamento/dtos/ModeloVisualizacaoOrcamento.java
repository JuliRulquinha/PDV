package com.crossmade.pdv.aplicacao.orcamento.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.orcamento.ItemDoOrcamento;
import com.crossmade.pdv.dominio.orcamento.StatusOrcamento;

public record ModeloVisualizacaoOrcamento(
    Integer id,
    List<ItemDoOrcamento> itens,
    ModeloVisualizacaoCliente cliente,
    Date validade,
    BigDecimal total,
    StatusOrcamento status,
    int desconto
) {}
