package com.crossmade.pdv.dominio.categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepositorio {

    Categoria salvar(Categoria categoria);
    Optional<Categoria> buscarPorId(Integer id);
    List<Categoria> listarTodas();
    void deletar(Integer id);
}
