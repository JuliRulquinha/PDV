package com.crossmade.pdv.aplicacao.produto.query.buscarTodos;

import java.util.List;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.mediator.IResponse;

public class BuscarTodosOsProdutosResponse implements IResponse{
    public List<Produto> produtos;
}
