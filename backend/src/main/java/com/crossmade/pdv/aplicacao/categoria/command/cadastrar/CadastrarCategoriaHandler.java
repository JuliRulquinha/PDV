package com.crossmade.pdv.aplicacao.categoria.command.cadastrar;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoCadastroCategoria;
import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoria;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.infraestrutura.categoria.CategoriaRepositorioIplm;

@Component
public class CadastrarCategoriaHandler {
    private final CategoriaRepositorioIplm repositorio;

    public CadastrarCategoriaHandler (CategoriaRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public DtoVisualizarCategoria handle(CadastrarCategoriaCommand command){
        DtoCadastroCategoria categoria = new DtoCadastroCategoria(command.nome(), command.descricao());
        return repositorio.salvar(categoria);
    }
}
