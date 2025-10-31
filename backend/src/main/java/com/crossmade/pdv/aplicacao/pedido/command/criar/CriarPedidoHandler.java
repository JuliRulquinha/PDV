package com.crossmade.pdv.aplicacao.pedido.command.criar;

import java.util.stream.Collectors;

import com.crossmade.pdv.infraestrutura.cliente.ClienteRepositorioIplm;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.aplicacao.pedido.mapper.MapperPedido;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import com.crossmade.pdv.dominio.pedido.Pedido;
import com.crossmade.pdv.infraestrutura.pedido.PedidoRepositorioIplm;

@Component
public class CriarPedidoHandler {
    private final PedidoRepositorioIplm pedidoRepositorio;
    private final ClienteRepositorioIplm clienteRepositorio;
    private final MapperPedido mapper;


    public CriarPedidoHandler(PedidoRepositorioIplm pedidoRepositorio, ClienteRepositorioIplm clienteRepositorio, MapperPedido mapper) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.mapper = mapper;

    }

    public ModeloVisualizacaoPedido handle(CriarPedidoCommand command) {

        if(command.cliente_id() != null){
            var cliente = clienteRepositorio.buscarPorId(command.cliente_id());
            var salvo = pedidoRepositorio.salvar(mapper.paraDominio(command, cliente));
            return mapper.paraModeloVisualizacao(salvo);
        }

        var salvo = pedidoRepositorio.salvar(mapper.paraDominio(command));
        return mapper.paraModeloVisualizacao(salvo);
    }
}
