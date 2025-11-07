package com.crossmade.pdv.aplicacao.cliente.command.atualizar;

import com.crossmade.pdv.dominio.endereco.Endereco;

import java.util.List;

public record AtualizarClienteCommand(
        Integer id,
        String nome,
        String telefone,
        String email,
        List<Endereco> enderecos
) {
}
