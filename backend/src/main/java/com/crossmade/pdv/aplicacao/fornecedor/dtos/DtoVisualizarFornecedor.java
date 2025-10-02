package com.crossmade.pdv.aplicacao.fornecedor.dtos;

import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.dominio.endereco.Endereco;

import java.util.List;

public record DtoVisualizarFornecedor(
        String nome,
        String telefone,
        String email,
        List<Endereco> enderecos,
        List<DtoVisualizarProduto> produtos
) {
}
