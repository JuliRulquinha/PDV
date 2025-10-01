package com.crossmade.pdv.infraestrutura.categoria;


import com.crossmade.pdv.aplicacao.categoria.dtos.ListaCategoriaDto;
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
    public Categoria buscarPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public ListaCategoriaDto listarTodas() {
        var lista = repositorio.findAll();
        return new ListaCategoriaDto(lista);
    }

    @Override
    public void deletar(Integer id) {
        repositorio.deleteById(id);
    }

}
