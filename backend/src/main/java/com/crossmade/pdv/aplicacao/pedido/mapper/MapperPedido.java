package com.crossmade.pdv.aplicacao.pedido.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.pedido.command.criar.CriarPedidoCommand;
import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.pedido.Pedido;

@Service
public class MapperPedido {
    public ModeloVisualizacaoPedido paraModeloVisualizacao(Pedido pedido) {
        var cliente =  pedido.getCliente();

        if(cliente != null){
            ModeloVisualizacaoCliente clienteDto = new ModeloVisualizacaoCliente(
                    cliente.getId(),
                    cliente.getnome(),
                    cliente.getTelefone(),
                    cliente.getEmail(),
                    cliente.getEnderecos()
            );

            return new ModeloVisualizacaoPedido(
                    pedido.getId(),
                    pedido.getItens(),
                    clienteDto,
                    pedido.getValidade(),
                    pedido.getTotal(),
                    pedido.getDesconto()
            );
        }

        return new ModeloVisualizacaoPedido(
            pedido.getId(),
            pedido.getItens(),
            null,
            pedido.getValidade(),
            pedido.getTotal(),
            pedido.getDesconto()
        );
    }


    public List<ModeloVisualizacaoPedido> paraListaDeModelos(List<Pedido> pedidos){
        return pedidos.stream().map(this::paraModeloVisualizacao).toList();
    }

    public Pedido paraDominio(CriarPedidoCommand modelo){
        return new Pedido(
                modelo.itens(),
                modelo.validade(),
                modelo.total(),
                modelo.desconto()
        );
    }

    public Pedido paraDominio(CriarPedidoCommand modelo, Cliente cliente){
        return new Pedido(
                modelo.itens(),
                cliente,
                modelo.validade(),
                modelo.total(),
                modelo.desconto()
        );
    }
}
