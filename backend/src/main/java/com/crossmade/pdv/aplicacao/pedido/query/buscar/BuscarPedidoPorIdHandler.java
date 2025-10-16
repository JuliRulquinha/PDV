package com.crossmade.pdv.aplicacao.pedido.query.buscar;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.aplicacao.pedido.dtos.DtoVisualizarPedido;
import com.crossmade.pdv.aplicacao.pedido.mapper.MapperPedido;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import com.crossmade.pdv.infraestrutura.pedido.PedidoRepositorioIplm;

@Component
public class BuscarPedidoPorIdHandler {
    private final PedidoRepositorioIplm repositorio;
    private final MapperPedido mapper;
    private final MapperCliente mapperCliente;
    private final MapperProduto mapperProduto;

    public BuscarPedidoPorIdHandler(PedidoRepositorioIplm repositorio, MapperPedido mapper, MapperCliente mapperCliente, MapperProduto mapperProduto) {
        this.repositorio = repositorio;
        this.mapper = mapper;
        this.mapperCliente = mapperCliente;
        this.mapperProduto = mapperProduto;
    }

    public DtoVisualizarPedido handle(BuscarPedidoPorIdQuery query) {
        var pedido = repositorio.buscarPorId(query.id());
        var clienteDto = mapperCliente.paraDtoDeVisualizar(pedido.getCliente());
        var produtosDto = pedido.getProdutos().stream().map(mapperProduto::paraDtoDeVisualizar).collect(Collectors.toList());
        return mapper.paraDtoDeVisualizar(pedido, clienteDto, produtosDto);
    }
}
