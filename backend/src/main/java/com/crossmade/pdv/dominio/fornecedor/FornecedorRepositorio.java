package com.crossmade.pdv.dominio.fornecedor;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.ListaFornecedoresDto;

import java.util.List;


public interface FornecedorRepositorio {
    Fornecedor salvar(Fornecedor fornecedor);
    Fornecedor buscarPorId(Integer id);
    ListaFornecedoresDto listarTodos();
    void deletar(Integer id);
}
