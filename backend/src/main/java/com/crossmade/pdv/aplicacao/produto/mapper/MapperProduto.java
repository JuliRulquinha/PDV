package com.crossmade.pdv.aplicacao.produto.mapper;

import com.crossmade.pdv.aplicacao.categoria.dtos.ModeloVisualizacaoCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ModeloVisualizacaoFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.produto.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapperProduto {

    public ModeloVisualizacaoProduto paraDtoDeVisualizar(Produto produto){
        var categoria = new ModeloVisualizacaoCategoriaDentroDeProduto(produto.getCategoria().getNome(), produto.getCategoria().getDescricao());
        var fornecedor = new ModeloVisualizacaoFornecedorDentroDeProduto(
                produto.getFornecedor().getNome(),
                produto.getFornecedor().getTelefone(),
                produto.getFornecedor().getEmail(),
                produto.getFornecedor().getEnderecos()
        );
        return new ModeloVisualizacaoProduto(
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

    public List<ModeloVisualizacaoProduto> paraListaDtoDeVisualizar(List<Produto> produtos){
        List<ModeloVisualizacaoProduto> dtos = new ArrayList<>();

        for(var produto: produtos){

            dtos.add(paraDtoDeVisualizar(produto));
        }

        return dtos;
    }
}
