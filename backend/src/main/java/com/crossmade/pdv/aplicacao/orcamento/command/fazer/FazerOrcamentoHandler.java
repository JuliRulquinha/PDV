package com.crossmade.pdv.aplicacao.orcamento.command.fazer;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.orcamento.dtos.DtoVisualizarOrcamento;
import com.crossmade.pdv.aplicacao.orcamento.mapper.MapperOrcamento;
import com.crossmade.pdv.infraestrutura.orcamento.OrcamentoRepositorioIplm;


@Component
public class FazerOrcamentoHandler {


    private final MapperOrcamento mapper;
    private final OrcamentoRepositorioIplm repositorio;

    public FazerOrcamentoHandler(MapperOrcamento mapper, OrcamentoRepositorioIplm repositorio) {
        this.mapper = mapper;
        this.repositorio = repositorio;
    }

    public DtoVisualizarOrcamento handle(FazerOrcamentoCommand command) {
        
        var salvo = repositorio.salvar(mapper.paraDominio(command));

        return mapper.paraDtoDeVisualizar(salvo);
    }
}
