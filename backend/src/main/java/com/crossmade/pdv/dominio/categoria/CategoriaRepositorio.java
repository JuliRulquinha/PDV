package com.crossmade.pdv.dominio.categoria;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoCadastroCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.ListaCategoriaDto;


public interface CategoriaRepositorio {

    DtoVisualizarCategoria salvar(DtoCadastroCategoria categoria);
    DtoVisualizarCategoria buscarPorId(Integer id);
    ListaCategoriaDto listarTodas();
    void deletar(Integer id);
}
