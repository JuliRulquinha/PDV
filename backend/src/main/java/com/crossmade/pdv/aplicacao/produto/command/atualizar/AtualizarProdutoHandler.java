package com.crossmade.pdv.aplicacao.produto.command.atualizar;


import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

import jakarta.persistence.EntityManager;

@Component
public class AtualizarProdutoHandler {


    private final ProdutoRepositorioIplm produtoRepositorio;
    private final EntityManager entityManager;

    public AtualizarProdutoHandler(ProdutoRepositorioIplm produtoRepositorio, EntityManager entityManager) {
        this.produtoRepositorio = produtoRepositorio;
        this.entityManager = entityManager;
    }

    public Produto handle(Integer id, AtualizarProdutoCommand command) {
        var categoria = entityManager.getReference(Categoria.class, command.categoria_id());
        var fornecedor = entityManager.getReference(Fornecedor.class, command.fornecedor_id());

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

        return produtoRepositorio.atualizar(id, produto);
    }
}
