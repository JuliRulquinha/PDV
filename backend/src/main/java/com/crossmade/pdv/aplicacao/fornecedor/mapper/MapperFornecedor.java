package com.crossmade.pdv.aplicacao.fornecedor.mapper;

import com.crossmade.pdv.aplicacao.categoria.dtos.ModeloVisualizacaoCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ModeloVisualizacaoFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapperFornecedor {


    public DtoVisualizarFornecedor paraDtoDeVisualizar(Fornecedor fornecedor){
        var produtos = fornecedor.getProdutos();
        List<ModeloVisualizacaoProduto> produtosDtos =  new ArrayList<>();

        var fornecedorVisualizar = new ModeloVisualizacaoFornecedorDentroDeProduto(
                fornecedor.getNome(),
                fornecedor.getEmail(),
                fornecedor.getTelefone(),
                fornecedor.getEnderecos()
        );
        for (var produtosDoFornecedor: produtos){

            var categoriaVisualizar = new ModeloVisualizacaoCategoriaDentroDeProduto(
                    produtosDoFornecedor.getCategoria().getNome(),
                    produtosDoFornecedor.getCategoria().getDescricao()
            );

            produtosDtos.add(
                    new ModeloVisualizacaoProduto(
                            produtosDoFornecedor.getNome(),
                            fornecedorVisualizar,
                            categoriaVisualizar,
                            produtosDoFornecedor.getMarca(),
                            produtosDoFornecedor.getModelo(),
                            produtosDoFornecedor.getQuantidade(),
                            produtosDoFornecedor.getValorCusto(),
                            produtosDoFornecedor.getValorVenda(),
                            produtosDoFornecedor.getImageUrl(),
                            produtosDoFornecedor.getValidade(),
                            produtosDoFornecedor.getDimensoes()
                    ));
        }
        return new DtoVisualizarFornecedor(
                fornecedor.getNome(),
                fornecedor.getTelefone(),
                fornecedor.getEmail(),
                fornecedor.getEnderecos(),
                produtosDtos
        );
    }

    public List<DtoVisualizarFornecedor> paraListaDtoDeVisualizar(List<Fornecedor> fornecedores){
        List<DtoVisualizarFornecedor> dtos = new ArrayList<>();

        for (var fornecedor: fornecedores){
            dtos.add(paraDtoDeVisualizar(fornecedor));
        }
        return dtos;
    }
}
