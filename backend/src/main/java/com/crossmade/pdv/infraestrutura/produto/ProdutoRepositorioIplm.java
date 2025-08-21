package com.crossmade.pdv.infraestrutura.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.dominio.produto.ProdutoRepositorio;

@Repository
public class ProdutoRepositorioIplm implements ProdutoRepositorio{

     private final SpringDataProdutoRepositorio repositorio;

    public ProdutoRepositorioIplm(SpringDataProdutoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public Produto salvar(Produto produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Produto> listarTodas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodas'");
    }

    @Override
    public void cancelar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelar'");
    }

}
