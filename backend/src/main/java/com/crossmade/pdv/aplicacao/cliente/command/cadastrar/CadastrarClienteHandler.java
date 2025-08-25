package com.crossmade.pdv.aplicacao.cliente.command.cadastrar;

import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.infraestrutura.cliente.ClienteRepositorioIplm;

public class CadastrarClienteHandler {

    private final ClienteRepositorioIplm repositorio;

    public CadastrarClienteHandler(ClienteRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public Cliente handle(CadastrarClienteCommand command){
        Cliente cliente = new Cliente(command.nome(),
                                      command.telefone(),
                                      command.email()

        );

        return repositorio.salvar(cliente);
    }
}
