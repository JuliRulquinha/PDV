package com.crossmade.pdv.aplicacao.pedido.dtos;

import java.util.List;

public record ListaPedidoDto(
        int contagem,
        List<ModeloVisualizacaoPedido> pedidos
) {}
