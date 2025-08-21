package com.crossmade.pdv.dominio.produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositorio {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(Integer id);
    List<Produto> listarTodas();
    void cancelar(Integer id);
}
