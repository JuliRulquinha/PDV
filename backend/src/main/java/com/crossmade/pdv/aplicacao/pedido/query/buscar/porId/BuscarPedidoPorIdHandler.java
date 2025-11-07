package com.crossmade.pdv.aplicacao.pedido.query.buscar.porId;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.aplicacao.pedido.mapper.MapperPedido;
import com.crossmade.pdv.infraestrutura.pedido.PedidoRepositorioIplm;

@Component
public class BuscarPedidoPorIdHandler {
    private final PedidoRepositorioIplm repositorio;
    private final MapperPedido mapper;


    public BuscarPedidoPorIdHandler(PedidoRepositorioIplm repositorio, MapperPedido mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;

    }

    public ModeloVisualizacaoPedido handle(BuscarPedidoPorIdQuery query) {
        var pedido = repositorio.buscarPorId(query.id());
        return mapper.paraModeloVisualizacao(pedido);
    }
}
