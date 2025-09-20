package com.crossmade.pdv.aplicacao.produto.command.atualizar;


import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

public class AtualizarProdutoHandler {
 private final ProdutoRepositorioIplm repositorio;

    public AtualizarProdutoHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public Produto handle(Integer id,AtualizarProdutoCommand command){
        Fornecedor fornecedor = new Fornecedor();
        Categoria categoria = new Categoria();

        fornecedor.setId(command.fornecedor_id());
        categoria.setId(command.categoria_id());

        Produto produto = new Produto(
                                      command.nome(), 
                                      fornecedor,
                                      categoria,
                                      command.marca(),
                                      command.modelo(),
                                      command.quantidade(),
                                      command.valorCusto(),
                                      command.valorVenda(),
                                      command.imageUrl(),
                                      command.validade(),
                                      command.dimensoes()
        );

        return repositorio.atualizar(id, produto);
}
}
