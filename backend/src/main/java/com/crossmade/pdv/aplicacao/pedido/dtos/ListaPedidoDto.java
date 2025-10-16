package com.crossmade.pdv.aplicacao.pedido.dtos;

import java.util.List;

public record ListaPedidoDto(
    List<DtoVisualizarPedido> pedidos
) {}
