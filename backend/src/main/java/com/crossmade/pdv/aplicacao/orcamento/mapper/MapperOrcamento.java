package com.crossmade.pdv.aplicacao.orcamento.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.categoria.dtos.ModeloVisualizacaoCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ModeloVisualizacaoFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.orcamento.command.fazer.FazerOrcamentoCommand;
import com.crossmade.pdv.aplicacao.orcamento.dtos.ModeloVisualizacaoOrcamento;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.orcamento.Orcamento;
import com.crossmade.pdv.dominio.produto.Produto;

@Service
public class MapperOrcamento {
    public ModeloVisualizacaoOrcamento paraModeloDeVisualizacao(Orcamento orcamento) {

        ModeloVisualizacaoCliente modeloVisualizacaoCliente = new ModeloVisualizacaoCliente(
                orcamento.getCliente().getId(),
                orcamento.getCliente().getnome(),
                orcamento.getCliente().getTelefone(),
                orcamento.getCliente().getEmail(),
                orcamento.getCliente().getEnderecos()
        );

        return new ModeloVisualizacaoOrcamento(
            orcamento.getId(),
            orcamento.getItens(),
            modeloVisualizacaoCliente,
            orcamento.getValidade(),
            orcamento.getTotal(),
            orcamento.getDesconto()
        );
    }

    public List<ModeloVisualizacaoOrcamento> paraModeloDeVisualizacao(List<Orcamento> orcamentos) {
     return orcamentos.stream()
            .map(this::paraModeloDeVisualizacao)
            .toList();
    }

    public Orcamento paraDominio(FazerOrcamentoCommand orcamento) {
        var cliente = new Cliente(orcamento.cliente().id(), orcamento.cliente().nome(), orcamento.cliente().telefone(), orcamento.cliente().email());
        return new Orcamento(orcamento.itens(), cliente, orcamento.validade(), orcamento.total(), orcamento.desconto());
    }
}
