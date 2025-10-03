package com.crossmade.pdv.aplicacao.categoria.mapper;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoCadastroCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.dominio.categoria.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapperCategoria {

    public Categoria dtoDeCadastroParaCategoria(DtoCadastroCategoria dto){
        return new Categoria(dto.nome(), dto.descricao());
    }

    public DtoVisualizarCategoria paraDtoDeVisualizar(Categoria categoria){
        var produtos = categoria.getProdutos();
        var categoriaVisualizar = new DtoVisualizarCategoriaDentroDeProduto(categoria.getNome(), categoria.getDescricao());
        List<DtoVisualizarProduto> produtosDtos =  new ArrayList<>();

        for (var produtosDaCategoria: produtos){
            var fornecedorVisualizar = new DtoVisualizarFornecedorDentroDeProduto(
                    produtosDaCategoria.getFornecedor().getNome(),
                    produtosDaCategoria.getFornecedor().getEmail(),
                    produtosDaCategoria.getFornecedor().getTelefone(),
                    produtosDaCategoria.getFornecedor().getEnderecos()
            );
            produtosDtos.add(
                    new DtoVisualizarProduto(
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
        return new DtoVisualizarCategoria(categoria.getNome(), categoria.getDescricao(), produtosDtos);
    }
}
