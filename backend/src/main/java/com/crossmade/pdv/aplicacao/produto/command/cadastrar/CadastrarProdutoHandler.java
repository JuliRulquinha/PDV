package com.crossmade.pdv.aplicacao.produto.command.cadastrar;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoCadastroProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class CadastrarProdutoHandler {
    private final ProdutoRepositorioIplm repositorio;

    public CadastrarProdutoHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public DtoVisualizarProduto handle(CadastrarProdutoCommand command){

        var produto = new DtoCadastroProduto(
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

        return repositorio.salvar(produto);
}
}
