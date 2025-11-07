package com.crossmade.pdv.aplicacao.cliente.query.buscar.todos;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.cliente.dtos.ListaClienteDto;
import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.infraestrutura.cliente.ClienteRepositorioIplm;

@Component
public class BuscarClientesHandler {

    private final ClienteRepositorioIplm repositorio;
    private final MapperCliente mapper;

    public BuscarClientesHandler(ClienteRepositorioIplm repositorio, MapperCliente mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public ListaClienteDto handle(BuscarClientesQuery query) {
        var clientes = repositorio.listarTodos()
                .stream()
                .map(mapper::paraDtoDeVisualizar)
                .toList();
        return new ListaClienteDto(clientes);
    }
}
