package com.crossmade.pdv.aplicacao.cliente.mapper;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.cliente.dtos.DtoVisualizarCliente;
import com.crossmade.pdv.dominio.cliente.Cliente;

@Service
public class MapperCliente {
    public DtoVisualizarCliente paraDtoDeVisualizar(Cliente cliente) {
        return new DtoVisualizarCliente(
            cliente.getId(),
            cliente.getnome(),
            cliente.getTelefone(),
            cliente.getEmail(),
            cliente.getEnderecos()
        );
    }
}
