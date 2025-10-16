package com.crossmade.pdv.aplicacao.produto.command.cadastrar;

import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class CadastrarProdutoHandler {
    private final ProdutoRepositorioIplm repositorio;
    private final MapperProduto mapper;

    public CadastrarProdutoHandler(ProdutoRepositorioIplm repositorio, MapperProduto mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }


    public ModeloVisualizacaoProduto handle(CadastrarProdutoCommand command){

        var produto = new Produto(
                  command.nome(),
                  command.fornecedor(),
                  command.categoria(),
                  command.marca(),
                  command.modelo(),
                  command.quantidade(),
                  command.valorCusto(),
                  command.valorVenda(),
                  command.imageUrl(),
                  command.validade(),
                  command.dimensoes()
        );

        var salvo = repositorio.salvar(produto);
        return mapper.paraDtoDeVisualizar(salvo);
}
}
