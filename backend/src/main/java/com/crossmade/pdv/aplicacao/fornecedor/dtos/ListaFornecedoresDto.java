package com.crossmade.pdv.aplicacao.fornecedor.dtos;

import java.util.List;

public record ListaFornecedoresDto(
        List<DtoVisualizarFornecedor> fornecedores
) {
}
