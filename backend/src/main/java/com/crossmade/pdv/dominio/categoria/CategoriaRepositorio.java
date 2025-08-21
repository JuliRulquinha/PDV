package com.crossmade.pdv.dominio.categoria;

import java.util.List;


public interface CategoriaRepositorio {

    Categoria salvar(Categoria categoria);
    Categoria buscarPorId(Integer id);
    List<Categoria> listarTodas();
    void deletar(Integer id);
}
