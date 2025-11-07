package com.crossmade.pdv.aplicacao.produto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.crossmade.pdv.aplicacao.produto.command.cadastrar.CadastrarProdutoCommand;
import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.categoria.dtos.ModeloVisualizacaoCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ModeloVisualizacaoFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.produto.Produto;

@Service
public class MapperProduto {

    public ModeloVisualizacaoProduto paraDtoDeVisualizar(Produto produto){
    var categoria = new ModeloVisualizacaoCategoriaDentroDeProduto(produto.getCategoria().getId(), produto.getCategoria().getNome(), produto.getCategoria().getDescricao());
    var fornecedor = new ModeloVisualizacaoFornecedorDentroDeProduto(
        produto.getFornecedor().getId(),
        produto.getFornecedor().getNome(),
        produto.getFornecedor().getTelefone(),
        produto.getFornecedor().getEmail(),
        produto.getFornecedor().getEnderecos()
    );
        return new ModeloVisualizacaoProduto(
                produto.getId(),
                produto.getNome(),
                fornecedor,
                categoria,
                produto.getMarca(),
                produto.getModelo(),
                produto.getQuantidade(),
                produto.getValorCusto(),
                produto.getValorVenda(),
                produto.getImageUrl(),
                produto.getValidade(),
                produto.getDimensoes()
        );
    }

    public Produto paraDominio(CadastrarProdutoCommand command, Categoria categoriaGerenciada, Fornecedor fornecedorGerenciado){
        return new Produto(
                command.nome(),
                fornecedorGerenciado,
                categoriaGerenciada,
                command.marca(),
                command.modelo(),
                command.quantidade(),
                command.valorCusto(),
                command.valorVenda(),
                command.imageUrl(),
                command.validade(),
                command.dimensoes()
        );
    }

    public List<ModeloVisualizacaoProduto> paraListaDtoDeVisualizar(List<Produto> produtos){
        List<ModeloVisualizacaoProduto> dtos = new ArrayList<>();

        for(var produto: produtos){

            dtos.add(paraDtoDeVisualizar(produto));
        }

        return dtos;
    }
}
