package com.crossmade.pdv.aplicacao.fornecedor.command.cadastrar;

import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.infraestrutura.fornecedor.FornecedorRepositorioIplm;

public class CadastrarFornecedorHandler {

    private final FornecedorRepositorioIplm repositorio;

    public CadastrarFornecedorHandler(FornecedorRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public Fornecedor handle(CadastrarFornecedorCommand command) {
        Fornecedor fornecedor = new Fornecedor(command.nome(), command.telefone(),command.email());
        return repositorio.salvar(fornecedor);
    }
}
