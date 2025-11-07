package com.crossmade.pdv.aplicacao.cliente.mapper;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.dominio.cliente.Cliente;

import java.util.List;

@Service
public class MapperCliente {
    public ModeloVisualizacaoCliente paraDtoDeVisualizar(Cliente cliente) {
        return new ModeloVisualizacaoCliente(
            cliente.getId(),
            cliente.getnome(),
            cliente.getTelefone(),
            cliente.getEndereco()
        );
    }

    public List<ModeloVisualizacaoCliente> paraListaDeDtoDeVisualizar(List<Cliente> clientes){
        return clientes.stream().map(this::paraDtoDeVisualizar).toList();
    }
}
