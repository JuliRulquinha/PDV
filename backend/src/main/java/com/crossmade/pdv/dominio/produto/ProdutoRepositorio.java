package com.crossmade.pdv.dominio.produto;

import java.util.List;


public interface ProdutoRepositorio {
    Produto salvar(Produto produto);
    Produto buscarPorId(Integer id);
    List<Produto> buscarPorNome(String nome);
    List<Produto> buscarPorCategoria(String categoria);
    List<Produto> listarTodos();
    void deletar(Integer id);
}
