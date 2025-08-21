package com.crossmade.pdv.dominio.orcamento;

import java.util.List;

public interface OrcamentoRepositorio {
    Orcamento salvar(Orcamento orcamento);
    Orcamento buscarPorId(Integer id);
    List<Orcamento> listarTodos();
    void cancelar(Integer id);
}
