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

        List<ModeloVisualizacaoProduto> modeloVisualizacaoProdutos = new ArrayList<>();
        ModeloVisualizacaoCliente modeloVisualizacaoCliente = new ModeloVisualizacaoCliente(
            orcamento.getCliente().getnome(), 
            orcamento.getCliente().getTelefone(), 
            orcamento.getCliente().getEmail(),
            orcamento.getCliente().getEnderecos()
        );

        for(var produto: orcamento.getProdutos()){

            var modeloVisualizacaoFornecedor = new ModeloVisualizacaoFornecedorDentroDeProduto(
                produto.getFornecedor().getNome(),
                produto.getFornecedor().getTelefone(),
                produto.getFornecedor().getEmail(),
                produto.getFornecedor().getEnderecos()
            );

            var categoria = new ModeloVisualizacaoCategoriaDentroDeProduto(produto.getCategoria().getNome(), produto.getCategoria().getDescricao());

            modeloVisualizacaoProdutos.add(
                new ModeloVisualizacaoProduto(
                    produto.getId(),
                    produto.getNome(), 
                    modeloVisualizacaoFornecedor,
                    categoria, 
                    produto.getMarca(), 
                    produto.getModelo(), 
                    produto.getQuantidade(), 
                    produto.getValorCusto(), 
                    produto.getValorVenda(),
                    produto.getImageUrl(),
                    produto.getValidade(), 
                    produto.getDimensoes()
                )
            );
        }

        return new ModeloVisualizacaoOrcamento(
            orcamento.getId(),
            modeloVisualizacaoProdutos,
            modeloVisualizacaoCliente,
            orcamento.getValidade(),
            orcamento.getTotal(),
            orcamento.getDesconto()
        );
    }

    public List<ModeloVisualizacaoOrcamento> paraModeloDeVisualizacao(List<Orcamento> orcamentos, List<ModeloVisualizacaoCliente> clientesDto, List<List<ModeloVisualizacaoProduto>> produtosDto) {
     return orcamentos.stream()
            .map(this::paraModeloDeVisualizacao)
            .toList();
    }

    public Orcamento paraDominio(FazerOrcamentoCommand orcamento) {

        List<Produto> produtos = new ArrayList<>();

        for(var produto: orcamento.produtos()) {

            var categoria = new Categoria(produto.categoria().nome(), produto.categoria().descricao());
            var fornecedor = new Fornecedor(
                produto.fornecedor().nome(),
                produto.fornecedor().telefone(),
                produto.fornecedor().email()
            );

            produtos.add(
                new Produto(
                    produto.nome(),
                    fornecedor,
                    categoria,
                    produto.marca(),
                    produto.modelo(),
                    produto.quantidade(),
                    produto.valorCusto(),
                    produto.valorVenda(),
                    produto.imageUrl(),
                    produto.validade(),
                    produto.dimensoes()
            ));

        }

        var cliente = new Cliente(orcamento.cliente().nome(), orcamento.cliente().telefone(), orcamento.cliente().email());

        return new Orcamento(produtos, cliente, orcamento.validade(), orcamento.total(), orcamento.desconto());
    }
}
