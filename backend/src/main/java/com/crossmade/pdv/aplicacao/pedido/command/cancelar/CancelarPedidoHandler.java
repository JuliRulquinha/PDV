package com.crossmade.pdv.aplicacao.pedido.command.cancelar;

import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.aplicacao.pedido.mapper.MapperPedido;
import com.crossmade.pdv.infraestrutura.pedido.PedidoRepositorioIplm;
import org.springframework.stereotype.Component;

@Component
public class CancelarPedidoHandler {

    private final MapperPedido mapper;
    private final PedidoRepositorioIplm repositorio;

    public CancelarPedidoHandler(MapperPedido mapper, PedidoRepositorioIplm repositorio) {
        this.mapper = mapper;
        this.repositorio = repositorio;
    }

    public ModeloVisualizacaoPedido handle(CancelarPedidoCommand command){
        var pedido = repositorio.cancelar(command.id());
        return mapper.paraModeloVisualizacao(pedido);
    }
}
