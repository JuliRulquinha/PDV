package com.crossmade.pdv.aplicacao.produto.query.por_id;

import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@Component
public class BuscarPorIdHandler {
    private final ProdutoRepositorioIplm repositorio;
    private final MapperProduto mapper;

    public BuscarPorIdHandler(ProdutoRepositorioIplm repositorio, MapperProduto mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }
   
    public ModeloVisualizacaoProduto handle(BuscarPorIdQuery query){
        var resposta = repositorio.buscarPorId(query.id());
        return mapper.paraDtoDeVisualizar(resposta);
    }
}
