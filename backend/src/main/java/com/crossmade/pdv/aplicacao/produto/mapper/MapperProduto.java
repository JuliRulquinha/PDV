package com.crossmade.pdv.aplicacao.produto.mapper;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.produto.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapperProduto {

    public DtoVisualizarProduto paraDtoDeVisualizar(Produto produto){
        var categoria = new DtoVisualizarCategoriaDentroDeProduto(produto.getCategoria().getNome(), produto.getCategoria().getDescricao());
        var fornecedor = new DtoVisualizarFornecedorDentroDeProduto(
                produto.getFornecedor().getNome(),
                produto.getFornecedor().getTelefone(),
                produto.getFornecedor().getEmail(),
                produto.getFornecedor().getEnderecos()
        );
        return new DtoVisualizarProduto(
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

    public List<DtoVisualizarProduto> paraListaDtoDeVisualizar(List<Produto> produtos){
        List<DtoVisualizarProduto> dtos = new ArrayList<>();

        for(var produto: produtos){

            dtos.add(paraDtoDeVisualizar(produto));
        }

        return dtos;
    }
}
