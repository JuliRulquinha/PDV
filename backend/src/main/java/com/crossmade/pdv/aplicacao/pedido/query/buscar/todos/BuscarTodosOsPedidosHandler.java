package com.crossmade.pdv.aplicacao.pedido.query.buscar.todos;

import com.crossmade.pdv.aplicacao.pedido.dtos.ListaPedidoDto;
import com.crossmade.pdv.aplicacao.pedido.mapper.MapperPedido;
import com.crossmade.pdv.infraestrutura.pedido.PedidoRepositorioIplm;
import org.springframework.stereotype.Component;

@Component
public class BuscarTodosOsPedidosHandler {
    private final MapperPedido mapper;
    private final PedidoRepositorioIplm repositorio;

    public BuscarTodosOsPedidosHandler(MapperPedido mapper, PedidoRepositorioIplm repositorio) {
        this.mapper = mapper;
        this.repositorio = repositorio;
    }

    public ListaPedidoDto handle(BuscarTodosOsPedidosQuery query){
        var pedidos = mapper.paraListaDeModelos(repositorio.listarTodos(query.pagina()));
        var contagem = repositorio.retornarContagem();

        return new ListaPedidoDto(contagem, pedidos);
    }
}
