package com.crossmade.pdv.aplicacao.produto.command.cadastrar;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class CadastrarProdutoHandler {
    private final ProdutoRepositorioIplm repositorio;

    public CadastrarProdutoHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public Produto handle(CadastrarProdutoCommand command){
        Fornecedor fornecedor = new Fornecedor();
        Categoria categoria = new Categoria();

        fornecedor.setId(command.fornecedor_id());
        categoria.setId(command.categoria_id());

        Produto produto = new Produto(command.nome(), 
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

        return repositorio.salvar(produto);
}
}
