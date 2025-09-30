package com.crossmade.pdv.aplicacao.produto.query.buscarTodos;

import java.util.List;

import com.crossmade.pdv.aplicacao.produto.dtos.ListaProdutoDto;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarTodosOsProdutosHandler {

    private final ProdutoRepositorioIplm repositorio;

    public BuscarTodosOsProdutosHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public ListaProdutoDto handle(BuscarTodosOsProdutosQuery query){
        var produtos = repositorio.listarTodos(query.pagina());
        var contagem = repositorio.retornarContagem();
        return new ListaProdutoDto(contagem, produtos);
    }
}
