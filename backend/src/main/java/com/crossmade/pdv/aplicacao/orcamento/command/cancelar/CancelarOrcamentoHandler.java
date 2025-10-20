package com.crossmade.pdv.aplicacao.orcamento.command.cancelar;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.orcamento.dtos.ModeloVisualizacaoOrcamento;
import com.crossmade.pdv.aplicacao.orcamento.mapper.MapperOrcamento;
import com.crossmade.pdv.infraestrutura.orcamento.OrcamentoRepositorioIplm;

@Component
public class CancelarOrcamentoHandler {

    private final MapperOrcamento mapper;
    private final OrcamentoRepositorioIplm repositorio;

    public CancelarOrcamentoHandler(MapperOrcamento mapper, OrcamentoRepositorioIplm repositorio) {
        this.mapper = mapper;
        this.repositorio = repositorio;
    }

    public ModeloVisualizacaoOrcamento handle(CancelarOrcamentoCommand command){
        var orcamento = repositorio.cancelar(command.id());
        return mapper.paraModeloDeVisualizacao(orcamento);
    }
}
