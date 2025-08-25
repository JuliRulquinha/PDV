package com.crossmade.pdv.aplicacao.fornecedor.command.cadastrar;

public record CadastrarFornecedorCommand(
    String nome,
    String telefone,
    String email
) {

}
