package com.crossmade.pdv.aplicacao.produto.query.por_id;

import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarPorIdHandler {
    private final ProdutoRepositorioIplm repositorio;

    public BuscarPorIdHandler(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }
   
    public DtoVisualizarProduto handle(BuscarPorIdQuery query){
        return repositorio.buscarPorId(query.id());
    }
}
