package com.crossmade.pdv.aplicacao.orcamento.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.crossmade.pdv.aplicacao.cliente.dtos.DtoVisualizarCliente;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;

public record DtoVisualizarOrcamento(
    Integer id,
    List<DtoVisualizarProduto> produtos,
    DtoVisualizarCliente cliente,
    Date validade,
    BigDecimal total,
    int desconto
) {}
