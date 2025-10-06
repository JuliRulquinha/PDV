package com.crossmade.pdv.aplicacao.fornecedor.query.buscarTodosOsFornecedores;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.ListaFornecedoresDto;
import com.crossmade.pdv.aplicacao.fornecedor.mapper.MapperFornecedor;
import com.crossmade.pdv.infraestrutura.fornecedor.FornecedorRepositorioIplm;
import org.springframework.stereotype.Component;

@Component
public class BuscarTodosOsFornecedoresHandler {

    private final FornecedorRepositorioIplm repositorio;
    private final MapperFornecedor mapper;

    public BuscarTodosOsFornecedoresHandler(FornecedorRepositorioIplm repositorio, MapperFornecedor mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public ListaFornecedoresDto handle(BuscarTodosOsFornecedoresQuery query){
        var lista = repositorio.listarTodos();
        return new ListaFornecedoresDto(mapper.paraListaDtoDeVisualizar(lista));
    }
}
