package com.crossmade.pdv.dominio.orcamento;

import java.util.List;
import java.util.Optional;

public interface OrcamentoRepositorio {
    Orcamento salvar(Orcamento orcamento);
    Optional<Orcamento> buscarPorId(Integer id);
    List<Orcamento> listarTodas();
    void cancelar(Integer id);
}
