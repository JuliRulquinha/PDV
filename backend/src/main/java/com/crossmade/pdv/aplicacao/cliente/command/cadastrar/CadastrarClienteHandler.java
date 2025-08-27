package com.crossmade.pdv.aplicacao.cliente.command.cadastrar;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.infraestrutura.cliente.ClienteRepositorioIplm;

@Component
public class CadastrarClienteHandler {

    private final ClienteRepositorioIplm repositorio;

    public CadastrarClienteHandler(ClienteRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public Cliente handle(CadastrarClienteCommand command){
        Cliente cliente = new Cliente(command.nome(),
                                      command.telefone(),
                                      command.email(),
                                      command.enderecos()

        );
        

        return repositorio.salvar(cliente);
    }
}
