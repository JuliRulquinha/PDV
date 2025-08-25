package com.crossmade.pdv.aplicacao.cliente.command.cadastrar;

public record CadastrarClienteCommand(
    String nome,
    String telefone,
    String email
){

}
