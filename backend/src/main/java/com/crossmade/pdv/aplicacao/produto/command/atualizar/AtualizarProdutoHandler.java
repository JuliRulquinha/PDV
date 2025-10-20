package com.crossmade.pdv.aplicacao.produto.command.atualizar;


import com.crossmade.pdv.infraestrutura.categoria.CategoriaRepositorioIplm;
import com.crossmade.pdv.infraestrutura.fornecedor.FornecedorRepositorioIplm;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

import jakarta.persistence.EntityManager;

@Component
public class AtualizarProdutoHandler {


    private final ProdutoRepositorioIplm produtoRepositorio;
    private final FornecedorRepositorioIplm fornecedorRepositorio;
    private final CategoriaRepositorioIplm categoriaRepositorioIplm;
    private final EntityManager entityManager;

    public AtualizarProdutoHandler(ProdutoRepositorioIplm produtoRepositorio, FornecedorRepositorioIplm fornecedorRepositorio, CategoriaRepositorioIplm categoriaRepositorioIplm, EntityManager entityManager) {
        this.produtoRepositorio = produtoRepositorio;
        this.fornecedorRepositorio = fornecedorRepositorio;
        this.categoriaRepositorioIplm = categoriaRepositorioIplm;
        this.entityManager = entityManager;
    }

    public Produto handle(Integer id, AtualizarProdutoCommand command) {

        Produto produto = new Produto(
            command.nome(),
            command.marca(),
            command.modelo(),
            command.quantidade(),
            command.valorCusto(),
            command.valorVenda(),
            command.imageUrl(),
            command.validade(),
            command.dimensoes()
        );

        return produtoRepositorio.atualizar(id, produto);
    }
}
