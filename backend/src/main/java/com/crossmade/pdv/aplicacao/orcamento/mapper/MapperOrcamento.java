package com.crossmade.pdv.aplicacao.orcamento.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.orcamento.command.fazer.FazerOrcamentoCommand;
import com.crossmade.pdv.aplicacao.orcamento.dtos.ModeloVisualizacaoOrcamento;
import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.orcamento.Orcamento;

@Service
public class MapperOrcamento {
    public ModeloVisualizacaoOrcamento paraModeloDeVisualizacao(Orcamento orcamento) {

        var cliente = orcamento.getCliente();

        if(cliente != null){
            ModeloVisualizacaoCliente modeloVisualizacaoCliente = new ModeloVisualizacaoCliente(
                    cliente.getId(),
                    cliente.getnome(),
                    cliente.getTelefone(),
                    cliente.getEmail(),
                    cliente.getEnderecos()
            );

            return new ModeloVisualizacaoOrcamento(
                    orcamento.getId(),
                    orcamento.getItens(),
                    modeloVisualizacaoCliente,
                    orcamento.getValidade(),
                    orcamento.getTotal(),
                    orcamento.getStatus(),
                    orcamento.getDesconto()
            );
        }


        return new ModeloVisualizacaoOrcamento(
                orcamento.getId(),
                orcamento.getItens(),
                null,
                orcamento.getValidade(),
                orcamento.getTotal(),
                orcamento.getStatus(),
                orcamento.getDesconto()
        );
    }

    public List<ModeloVisualizacaoOrcamento> paraModeloDeVisualizacao(List<Orcamento> orcamentos) {
     return orcamentos.stream()
            .map(this::paraModeloDeVisualizacao)
            .toList();
    }

    public Orcamento paraDominio(FazerOrcamentoCommand orcamento, Cliente cliente) {
        return new Orcamento(orcamento.itens(), cliente, orcamento.validade(), orcamento.total(), orcamento.desconto());
    }

    public Orcamento paraDominio(FazerOrcamentoCommand orcamento) {
        return new Orcamento(orcamento.itens(), orcamento.validade(), orcamento.total(), orcamento.desconto());
    }
}
