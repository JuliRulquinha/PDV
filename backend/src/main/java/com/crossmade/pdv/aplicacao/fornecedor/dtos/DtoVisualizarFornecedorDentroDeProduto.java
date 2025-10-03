package com.crossmade.pdv.aplicacao.fornecedor.dtos;

import com.crossmade.pdv.dominio.endereco.Endereco;

import java.util.List;

public record DtoVisualizarFornecedorDentroDeProduto(
        String nome,
        String telefone,
        String email,
        List<Endereco> enderecos
) {
}
