package com.crossmade.pdv.aplicacao.pedido.command.criar;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.aplicacao.pedido.mapper.MapperPedido;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import com.crossmade.pdv.dominio.pedido.Pedido;
import com.crossmade.pdv.infraestrutura.pedido.PedidoRepositorioIplm;

@Component
public class CriarPedidoHandler {
    private final PedidoRepositorioIplm repositorio;
    private final MapperPedido mapper;


    public CriarPedidoHandler(PedidoRepositorioIplm repositorio, MapperPedido mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;

    }

    public ModeloVisualizacaoPedido handle(CriarPedidoCommand command) {
        var pedido = new Pedido(
            command.produtos(),
            command.cliente(),
            command.validade(),
            command.total(),
            command.desconto()
        );
        var salvo = repositorio.salvar(pedido);

        return mapper.paraModeloVisualizacao(salvo);
    }
}
