package com.crossmade.pdv.aplicacao.cliente.mapper;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.dominio.cliente.Cliente;

@Service
public class MapperCliente {
    public ModeloVisualizacaoCliente paraDtoDeVisualizar(Cliente cliente) {
        return new ModeloVisualizacaoCliente(

            cliente.getId(),
            cliente.getnome(),
            cliente.getTelefone(),
            cliente.getEmail(),
            cliente.getEnderecos()
        );
    }
}
