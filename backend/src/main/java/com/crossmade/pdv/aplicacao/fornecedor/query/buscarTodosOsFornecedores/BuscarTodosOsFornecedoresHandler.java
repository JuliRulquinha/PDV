package com.crossmade.pdv.aplicacao.fornecedor.query.buscarTodosOsFornecedores;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.ListaFornecedoresDto;
import com.crossmade.pdv.infraestrutura.fornecedor.FornecedorRepositorioIplm;
import org.springframework.stereotype.Component;

@Component
public class BuscarTodosOsFornecedoresHandler {

    private final FornecedorRepositorioIplm repositorio;

    public BuscarTodosOsFornecedoresHandler(FornecedorRepositorioIplm repositorio) {
        this.repositorio = repositorio;
    }

    public ListaFornecedoresDto handle(BuscarTodosOsFornecedoresQuery query){
        return repositorio.listarTodos();
    }
}
