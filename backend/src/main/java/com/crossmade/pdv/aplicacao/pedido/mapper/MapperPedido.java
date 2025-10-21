package com.crossmade.pdv.aplicacao.pedido.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.categoria.dtos.ModeloVisualizacaoCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ModeloVisualizacaoFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.pedido.command.criar.CriarPedidoCommand;
import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.endereco.Endereco;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.pedido.Pedido;
import com.crossmade.pdv.dominio.produto.Produto;

@Service
public class MapperPedido {
    public ModeloVisualizacaoPedido paraModeloVisualizacao(Pedido pedido) {
        List<Endereco> enderecos = pedido.getCliente().getEnderecos();
        ModeloVisualizacaoCliente clienteDto = new ModeloVisualizacaoCliente(
                pedido.getCliente().getId(),
                pedido.getCliente().getnome(),
                pedido.getCliente().getTelefone(),
                pedido.getCliente().getEmail(),
                enderecos
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

    public List<ModeloVisualizacaoPedido> paraListaDeModelos(List<Pedido> pedidos){
        return pedidos.stream().map(this::paraModeloVisualizacao).toList();
    }

    public Pedido paraDominio(CriarPedidoCommand modelo){

        var cliente = new Cliente(modelo.cliente().nome(), modelo.cliente().telefone(), modelo.cliente().email());

        return new Pedido(
                modelo.itens(),
                cliente,
                modelo.validade(),
                modelo.total(),
                modelo.desconto()
        );
    }
}
