package com.crossmade.pdv.aplicacao.cliente.query.buscar.porId;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.cliente.dtos.DtoVisualizarCliente;
import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.infraestrutura.cliente.ClienteRepositorioIplm;

@Component
public class BuscarClientePorIdHandler {
    private final ClienteRepositorioIplm repositorio;
    private final MapperCliente mapper;

    public BuscarClientePorIdHandler(ClienteRepositorioIplm repositorio, MapperCliente mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public DtoVisualizarCliente handle(BuscarClientePorIdQuery query) {
        var cliente = repositorio.buscarPorId(query.id());
        return mapper.paraDtoDeVisualizar(cliente);
    }
}
