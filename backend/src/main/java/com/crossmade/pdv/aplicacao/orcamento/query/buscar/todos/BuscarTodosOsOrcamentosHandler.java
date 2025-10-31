package com.crossmade.pdv.aplicacao.orcamento.query.buscar.todos;

import com.crossmade.pdv.aplicacao.orcamento.dtos.ListaOrcamentoDto;
import com.crossmade.pdv.aplicacao.orcamento.mapper.MapperOrcamento;
import com.crossmade.pdv.infraestrutura.orcamento.OrcamentoRepositorioIplm;
import org.springframework.stereotype.Component;

@Component
public class BuscarTodosOsOrcamentosHandler {

    private final OrcamentoRepositorioIplm repositorio;
    private final MapperOrcamento mapper;

    public BuscarTodosOsOrcamentosHandler(OrcamentoRepositorioIplm repositorio, MapperOrcamento mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public ListaOrcamentoDto handle(BuscarTodosOrcamentosQuery query){
        var orcamentos = mapper.paraModeloDeVisualizacao(repositorio.listarTodos(query.pagina()));
        var contagem = repositorio.retornarContagem();
        return new ListaOrcamentoDto(contagem, orcamentos);
    }
}
