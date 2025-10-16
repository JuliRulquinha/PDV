package com.crossmade.pdv.aplicacao.pedido.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.cliente.dtos.DtoVisualizarCliente;
import com.crossmade.pdv.aplicacao.pedido.dtos.DtoVisualizarPedido;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.dominio.pedido.Pedido;

@Service
public class MapperPedido {
    public DtoVisualizarPedido paraDtoDeVisualizar(Pedido pedido, DtoVisualizarCliente clienteDto, List<DtoVisualizarProduto> produtosDto) {
        return new DtoVisualizarPedido(
            pedido.getId(),
            produtosDto,
            clienteDto,
            pedido.getValidade(),
            pedido.getTotal(),
            pedido.getDesconto()
        );
    }
}
