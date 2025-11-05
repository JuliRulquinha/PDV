package com.crossmade.pdv.aplicacao.cliente.command.cadastrar;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.infraestrutura.cliente.ClienteRepositorioIplm;

@Component
public class CadastrarClienteHandler {

    private final ClienteRepositorioIplm repositorio;
    private final MapperCliente mapper;

    public CadastrarClienteHandler(ClienteRepositorioIplm repositorio, MapperCliente mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public ModeloVisualizacaoCliente handle(CadastrarClienteCommand command){
        Cliente cliente = new Cliente(command.nome(),
                                      command.telefone(),
                                      command.endereco()

        );
        var salvo = repositorio.salvar(cliente);

        return mapper.paraDtoDeVisualizar(salvo);
    }
}
