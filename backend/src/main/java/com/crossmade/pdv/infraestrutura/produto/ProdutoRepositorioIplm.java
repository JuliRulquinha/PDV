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
        return repositorio.save(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public List<Produto> listarTodos() {
       return repositorio.findAll();
    }

    @Override
    public void deletar(Integer id) {
        repositorio.deleteById(id);
    }

}
