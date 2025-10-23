package com.crossmade.pdv.aplicacao.produto.command.cadastrar;

import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import com.crossmade.pdv.infraestrutura.categoria.CategoriaRepositorioIplm;
import com.crossmade.pdv.infraestrutura.fornecedor.FornecedorRepositorioIplm;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class CadastrarProdutoHandler {
    private final ProdutoRepositorioIplm produtoRepositorio;
    private final CategoriaRepositorioIplm categoriaRepositorio;
    private final FornecedorRepositorioIplm fornecedorRepositorio;
    private final MapperProduto mapper;

    public CadastrarProdutoHandler(ProdutoRepositorioIplm produtoRepositorio, CategoriaRepositorioIplm categoriaRepositorio, FornecedorRepositorioIplm fornecedorRepositorio, MapperProduto mapper){
        this.produtoRepositorio = produtoRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
        this.fornecedorRepositorio = fornecedorRepositorio;

        this.mapper = mapper;
    }


    public ModeloVisualizacaoProduto handle(CadastrarProdutoCommand command){

        var categoria = categoriaRepositorio.buscarPorId(command.categoria_id());
        var fornecedor = fornecedorRepositorio.buscarPorId(command.fornecedor_id());

        var produto = mapper.paraDominio(command, categoria, fornecedor);

        var salvo = produtoRepositorio.salvar(produto);
        return mapper.paraDtoDeVisualizar(salvo);
}
}
