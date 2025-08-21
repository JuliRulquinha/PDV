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
        return repositorio.save(categoria);
    }

    @Override
    public Optional<Categoria> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public List<Categoria> listarTodas() {
       return repositorio.findAll();
    }

    @Override
    public void deletar(Integer id) {
        repositorio.deleteById(id);
    }

}
