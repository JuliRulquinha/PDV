package com.crossmade.pdv.aplicacao.categoria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.ModeloVisualizacaoCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ModeloVisualizacaoFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.categoria.Categoria;

@Service
public class MapperCategoria {

    public DtoVisualizarCategoria paraDtoDeVisualizar(Categoria categoria){
        var produtos = categoria.getProdutos();
        var categoriaVisualizar = new ModeloVisualizacaoCategoriaDentroDeProduto(categoria.getId(), categoria.getNome(), categoria.getDescricao());
        List<ModeloVisualizacaoProduto> produtosDtos =  new ArrayList<>();

        for (var produtosDaCategoria: produtos){
        var fornecedorVisualizar = new ModeloVisualizacaoFornecedorDentroDeProduto(
            produtosDaCategoria.getFornecedor().getId(),
            produtosDaCategoria.getFornecedor().getNome(),
            produtosDaCategoria.getFornecedor().getEmail(),
            produtosDaCategoria.getFornecedor().getTelefone(),
            produtosDaCategoria.getFornecedor().getEnderecos()
        );
            produtosDtos.add(
                    new ModeloVisualizacaoProduto(
                        produtosDaCategoria.getId(),
                        produtosDaCategoria.getNome(),
                        fornecedorVisualizar,
                        categoriaVisualizar,
                        produtosDaCategoria.getMarca(),
                        produtosDaCategoria.getModelo(),
                        produtosDaCategoria.getQuantidade(),
                        produtosDaCategoria.getValorCusto(),
                        produtosDaCategoria.getValorVenda(),
                        produtosDaCategoria.getImageUrl(),
                        produtosDaCategoria.getValidade(),
                        produtosDaCategoria.getDimensoes()
            ));
        }
    return new DtoVisualizarCategoria(categoria.getId(), categoria.getNome(), categoria.getDescricao(), produtosDtos);
    }

    public List<DtoVisualizarCategoria> paraListaDtoVisualizar(List<Categoria> categorias){
        List<DtoVisualizarCategoria> dtos = new ArrayList<>();
        for(var categoria: categorias){
            dtos.add(paraDtoDeVisualizar(categoria));
        }
        return dtos;
    }
}
