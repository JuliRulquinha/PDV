package com.crossmade.pdv.infraestrutura.categoria;


import com.crossmade.pdv.aplicacao.categoria.dtos.DtoCadastroCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.ListaCategoriaDto;
import com.crossmade.pdv.aplicacao.categoria.mapper.MapperCategoria;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import org.springframework.stereotype.Repository;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.categoria.CategoriaRepositorio;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepositorioIplm implements CategoriaRepositorio{

    private final SpringDataCategoriaRepositorio repositorio;
    private final MapperCategoria mapper;

    public CategoriaRepositorioIplm(SpringDataCategoriaRepositorio repositorio, MapperCategoria mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public DtoVisualizarCategoria salvar(DtoCadastroCategoria categoria) {
        var salvo = repositorio.save(mapper.dtoDeCadastroParaCategoria(categoria));
        return mapper.paraDtoDeVisualizar(salvo);
    }

    @Override
    public DtoVisualizarCategoria buscarPorId(Integer id) {
        var categoriaDoDb = repositorio.findById(id).orElse(null);
        return mapper.paraDtoDeVisualizar(categoriaDoDb);
    }

    @Override
    public ListaCategoriaDto listarTodas() {
        var lista = repositorio.findAll();
        List<DtoVisualizarCategoria> dtos = new ArrayList<>();

        for (var categoria: lista){
            dtos.add(mapper.paraDtoDeVisualizar(categoria));
        }

        return new ListaCategoriaDto(dtos);
    }

    @Override
    public void deletar(Integer id) {
        repositorio.deleteById(id);
    }

}
