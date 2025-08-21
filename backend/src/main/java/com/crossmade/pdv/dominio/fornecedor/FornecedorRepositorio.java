package com.crossmade.pdv.dominio.fornecedor;

import java.util.List;
import java.util.Optional;

public interface FornecedorRepositorio {
    Fornecedor salvar(Fornecedor fornecedor);
    Optional<Fornecedor> buscarPorId(Integer id);
    List<Fornecedor> listarTodas();
    void deletar(Integer id);
}
