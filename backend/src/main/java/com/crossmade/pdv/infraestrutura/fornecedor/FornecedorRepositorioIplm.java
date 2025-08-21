package com.crossmade.pdv.infraestrutura.fornecedor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.fornecedor.FornecedorRepositorio;


@Repository
public class FornecedorRepositorioIplm implements FornecedorRepositorio{

     private final SpringDataFornecedorRepositorio repositorio;

    public FornecedorRepositorioIplm(SpringDataFornecedorRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public Fornecedor salvar(Fornecedor fornecedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public Optional<Fornecedor> buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Fornecedor> listarTodas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodas'");
    }

    @Override
    public void deletar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

}
