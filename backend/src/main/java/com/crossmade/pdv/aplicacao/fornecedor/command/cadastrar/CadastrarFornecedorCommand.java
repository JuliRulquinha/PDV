package com.crossmade.pdv.aplicacao.fornecedor.command.cadastrar;

import java.util.List;

import com.crossmade.pdv.dominio.endereco.Endereco;

public record CadastrarFornecedorCommand(
    String nome,
    String telefone,
    String email,
    List<Endereco> enderecos
) {

}
