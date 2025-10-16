package com.crossmade.pdv.aplicacao.orcamento.query.buscar;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.aplicacao.orcamento.dtos.ModeloVisualizacaoOrcamento;
import com.crossmade.pdv.aplicacao.orcamento.mapper.MapperOrcamento;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import com.crossmade.pdv.infraestrutura.orcamento.OrcamentoRepositorioIplm;

@Component
public class BuscarOrcamentoPorIdHandler {
    private final OrcamentoRepositorioIplm repositorio;
    private final MapperOrcamento mapper;

    public BuscarOrcamentoPorIdHandler(OrcamentoRepositorioIplm repositorio, MapperOrcamento mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public ModeloVisualizacaoOrcamento handle(BuscarOrcamentoPorIdQuery query) {
        var orcamento = repositorio.buscarPorId(query.id());
        return mapper.paraModeloDeVisualizacao(orcamento);
    }
}
