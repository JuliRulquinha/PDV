package com.crossmade.pdv.aplicacao.orcamento.command.fazer;

import com.crossmade.pdv.infraestrutura.cliente.ClienteRepositorioIplm;
import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.orcamento.dtos.ModeloVisualizacaoOrcamento;
import com.crossmade.pdv.aplicacao.orcamento.mapper.MapperOrcamento;
import com.crossmade.pdv.infraestrutura.orcamento.OrcamentoRepositorioIplm;


@Component
public class FazerOrcamentoHandler {
    private final MapperOrcamento mapper;
    private final OrcamentoRepositorioIplm orcamentoRepositorio;
    private final ClienteRepositorioIplm clienteRepositorio;

    public FazerOrcamentoHandler(MapperOrcamento mapper, OrcamentoRepositorioIplm orcamentoRepositorio, ClienteRepositorioIplm clienteRepositorio) {
        this.mapper = mapper;
        this.orcamentoRepositorio = orcamentoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    public ModeloVisualizacaoOrcamento handle(FazerOrcamentoCommand command) {

        if(command.cliente_id() != null){
            var cliente = clienteRepositorio.buscarPorId(command.cliente_id());
            var salvo = orcamentoRepositorio.salvar(mapper.paraDominio(command, cliente));
            return mapper.paraModeloDeVisualizacao(salvo);
        }

        var salvo = orcamentoRepositorio.salvar(mapper.paraDominio(command));
        return mapper.paraModeloDeVisualizacao(salvo);
    }
}
