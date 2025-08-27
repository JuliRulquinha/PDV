package com.crossmade.pdv.aplicacao.cliente.command.cadastrar;

import java.util.List;

import com.crossmade.pdv.dominio.endereco.Endereco;

public record CadastrarClienteCommand(
    String nome,
    String telefone,
    String email,
    List<Endereco> enderecos
){

}
