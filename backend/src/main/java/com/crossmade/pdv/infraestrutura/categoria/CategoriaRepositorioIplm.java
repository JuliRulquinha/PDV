package com.crossmade.pdv.infraestrutura.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.categoria.CategoriaRepositorio;

@Repository
public class CategoriaRepositorioIplm implements CategoriaRepositorio{

    private final SpringDataCategoriaRepositorio repositorio;

    public CategoriaRepositorioIplm(SpringDataCategoriaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public Optional<Categoria> buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Categoria> listarTodas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodas'");
    }

    @Override
    public void deletar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

}
