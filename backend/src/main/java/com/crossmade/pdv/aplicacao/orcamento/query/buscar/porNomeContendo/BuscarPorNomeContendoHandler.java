package com.crossmade.pdv.aplicacao.orcamento.query.buscar.porNomeContendo;

import com.crossmade.pdv.aplicacao.cliente.dtos.ListaClienteDto;
import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.infraestrutura.cliente.ClienteRepositorioIplm;
import org.springframework.stereotype.Component;

@Component
public class BuscarPorNomeContendoHandler {
    private final ClienteRepositorioIplm repositorio;
    private final MapperCliente mapper;

    public BuscarPorNomeContendoHandler(ClienteRepositorioIplm repositorio, MapperCliente mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public ListaClienteDto handle(BuscarPorNomeContendoQuery query){
        var clientesDoDb = mapper.paraListaDeDtoDeVisualizar(repositorio.listarTodos(query.nome()));
        return new ListaClienteDto(clientesDoDb);
    }
}
