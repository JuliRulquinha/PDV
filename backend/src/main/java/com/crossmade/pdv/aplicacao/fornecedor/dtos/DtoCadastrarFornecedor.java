package com.crossmade.pdv.aplicacao.fornecedor.dtos;

import java.util.List;

import com.crossmade.pdv.dominio.endereco.Endereco;

public record DtoCadastrarFornecedor(
         String nome,
         String telefone,
         String email,
         List<Endereco> enderecos
) {
}
