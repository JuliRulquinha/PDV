package com.crossmade.pdv.dominio.produto;

import java.util.List;


public interface ProdutoRepositorio {
    Produto salvar(Produto produto);
    Produto buscarPorId(Integer id);
    List<Produto> buscarTodos();
    List<Produto> buscarPorNome(String nome);
    List<Produto> buscarPorCategoria(String categoria);
    List<Produto> listarTodos(int pagina);
    void deletar(Integer id);
    Produto atualizar(Integer id, Produto produto);
    int retornarContagem();
}
