package com.crossmade.pdv.aplicacao.produto.mapper;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoCadastroProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.produto.Produto;
import org.springframework.stereotype.Service;

@Service
public class MapperProduto {
    public Produto dtoDeCadastroParaProduto(DtoCadastroProduto dto){
        var categoria = new Categoria(dto.categoria().nome(), dto.categoria().descricao());
        var fornecedor = new Fornecedor(dto.fornecedor().nome(), dto.fornecedor().telefone(), dto.fornecedor().email());
        return new Produto(
                dto.nome(),
                fornecedor,
                categoria,
                dto.marca(),
                dto.modelo(),
                dto.quantidade(),
                dto.valorCusto(),
                dto.valorVenda(),
                dto.imageUrl(),
                dto.validade(),
                dto.dimensoes()
        );
    }

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
}
