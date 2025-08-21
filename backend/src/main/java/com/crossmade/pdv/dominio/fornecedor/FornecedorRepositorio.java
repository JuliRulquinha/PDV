package com.crossmade.pdv.dominio.fornecedor;

import java.util.List;


public interface FornecedorRepositorio {
    Fornecedor salvar(Fornecedor fornecedor);
    Fornecedor buscarPorId(Integer id);
    List<Fornecedor> listarTodos();
    void deletar(Integer id);
}
