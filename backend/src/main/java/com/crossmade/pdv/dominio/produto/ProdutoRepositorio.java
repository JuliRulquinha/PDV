package com.crossmade.pdv.dominio.produto;

import com.crossmade.pdv.aplicacao.produto.dtos.DtoCadastroProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;

import java.util.List;


public interface ProdutoRepositorio {
    DtoVisualizarProduto salvar(DtoCadastroProduto produto);
    DtoVisualizarProduto buscarPorId(Integer id);
    List<DtoVisualizarProduto> buscarTodos();
    List<DtoVisualizarProduto> buscarPorNome(String nome);
    List<DtoVisualizarProduto> buscarPorCategoria(String categoria);
    List<DtoVisualizarProduto> listarTodos(int pagina);
    void deletar(Integer id);
    Produto atualizar(Integer id, Produto produto);
    int retornarContagem();
}
