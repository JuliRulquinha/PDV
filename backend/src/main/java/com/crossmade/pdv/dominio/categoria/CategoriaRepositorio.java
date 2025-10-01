package com.crossmade.pdv.dominio.categoria;

import com.crossmade.pdv.aplicacao.categoria.dtos.ListaCategoriaDto;


public interface CategoriaRepositorio {

    Categoria salvar(Categoria categoria);
    Categoria buscarPorId(Integer id);
    ListaCategoriaDto listarTodas();
    void deletar(Integer id);
}
