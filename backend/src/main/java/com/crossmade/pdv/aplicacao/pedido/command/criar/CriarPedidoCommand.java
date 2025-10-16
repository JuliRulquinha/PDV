package com.crossmade.pdv.aplicacao.pedido.command.criar;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.produto.Produto;

public record CriarPedidoCommand(
    List<ModeloVisualizacaoProduto> produtos,
    ModeloVisualizacaoCliente cliente,
    Date validade,
    BigDecimal total,
    int desconto
) {}
