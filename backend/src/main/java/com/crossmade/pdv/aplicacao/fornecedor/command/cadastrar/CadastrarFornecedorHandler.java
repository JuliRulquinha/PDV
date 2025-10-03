package com.crossmade.pdv.aplicacao.fornecedor.command.cadastrar;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoCadastrarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.infraestrutura.fornecedor.FornecedorRepositorioIplm;

@Component
public class CadastrarFornecedorHandler {

    private final FornecedorRepositorioIplm repositorio;

    public CadastrarFornecedorHandler(FornecedorRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public DtoVisualizarFornecedor handle(CadastrarFornecedorCommand command) {
        DtoCadastrarFornecedor fornecedor = new DtoCadastrarFornecedor(command.nome(), command.telefone(),command.email(),command.enderecos());
        return repositorio.salvar(fornecedor);
    }
}
