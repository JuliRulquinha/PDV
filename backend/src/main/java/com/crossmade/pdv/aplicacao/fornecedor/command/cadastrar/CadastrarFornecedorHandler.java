package com.crossmade.pdv.aplicacao.fornecedor.command.cadastrar;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoCadastrarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.mapper.MapperFornecedor;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.infraestrutura.fornecedor.FornecedorRepositorioIplm;

@Component
public class CadastrarFornecedorHandler {

    private final FornecedorRepositorioIplm repositorio;
    private final MapperFornecedor mapper;

    public CadastrarFornecedorHandler(FornecedorRepositorioIplm repositorio, MapperFornecedor mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public DtoVisualizarFornecedor handle(CadastrarFornecedorCommand command) {
        Fornecedor fornecedor = new Fornecedor(command.nome(), command.telefone(),command.email());
        var salvo = repositorio.salvar(fornecedor);
        return mapper.paraDtoDeVisualizar(salvo);
    }
}
