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
        return repositorio.save(fornecedor);
    }

    @Override
    public Optional<Fornecedor> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public List<Fornecedor> listarTodos() {
        return repositorio.findAll();
    }

    @Override
    public void deletar(Integer id) {
        repositorio.deleteById(id);
    }

}
