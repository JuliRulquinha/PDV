package com.crossmade.pdv.aplicacao.fornecedor.dtos;

import com.crossmade.pdv.dominio.fornecedor.Fornecedor;

import java.util.List;

public record ListaFornecedoresDto(
        List<Fornecedor> fornecedores
) {
}
