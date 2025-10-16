package com.crossmade.pdv.aplicacao.pedido.command.criar;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.aplicacao.pedido.dtos.DtoVisualizarPedido;
import com.crossmade.pdv.aplicacao.pedido.mapper.MapperPedido;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import com.crossmade.pdv.dominio.pedido.Pedido;
import com.crossmade.pdv.infraestrutura.pedido.PedidoRepositorioIplm;

@Component
public class CriarPedidoHandler {
    private final PedidoRepositorioIplm repositorio;
    private final MapperPedido mapper;
    private final MapperCliente mapperCliente;
    private final MapperProduto mapperProduto;

    public CriarPedidoHandler(PedidoRepositorioIplm repositorio, MapperPedido mapper, MapperCliente mapperCliente, MapperProduto mapperProduto) {
        this.repositorio = repositorio;
        this.mapper = mapper;
        this.mapperCliente = mapperCliente;
        this.mapperProduto = mapperProduto;
    }

    public DtoVisualizarPedido handle(CriarPedidoCommand command) {
        var pedido = new Pedido(
            command.produtos(),
            command.cliente(),
            command.validade(),
            command.total(),
            command.desconto()
        );
        var salvo = repositorio.salvar(pedido);
        var clienteDto = mapperCliente.paraDtoDeVisualizar(salvo.getCliente());
        var produtosDto = salvo.getProdutos().stream().map(mapperProduto::paraDtoDeVisualizar).collect(Collectors.toList());
        return mapper.paraDtoDeVisualizar(salvo, clienteDto, produtosDto);
    }
}
