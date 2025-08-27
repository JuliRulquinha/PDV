package com.crossmade.pdv.aplicacao.categoria.command.cadastrar;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.infraestrutura.categoria.CategoriaRepositorioIplm;

@Component
public class CadastrarCategoriaHandler {
    private final CategoriaRepositorioIplm repositorio;

    public CadastrarCategoriaHandler (CategoriaRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    public Categoria handle(CadastrarCategoriaCommand command){
        Categoria categoria = new Categoria(command.nome(), command.descricao());
        return repositorio.salvar(categoria);
    }
}
