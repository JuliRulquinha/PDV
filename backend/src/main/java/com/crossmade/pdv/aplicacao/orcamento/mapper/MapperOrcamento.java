package com.crossmade.pdv.aplicacao.orcamento.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.categoria.dtos.DtoVisualizarCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.cliente.dtos.DtoVisualizarCliente;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.orcamento.command.fazer.FazerOrcamentoCommand;
import com.crossmade.pdv.aplicacao.orcamento.dtos.DtoVisualizarOrcamento;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.orcamento.Orcamento;
import com.crossmade.pdv.dominio.produto.Produto;

@Service
public class MapperOrcamento {
    public DtoVisualizarOrcamento paraDtoDeVisualizar(Orcamento orcamento) {

        List<DtoVisualizarProduto> produtosDto = new ArrayList<>();
        DtoVisualizarCliente clienteDto = new DtoVisualizarCliente(
            orcamento.getCliente().getnome(), 
            orcamento.getCliente().getTelefone(), 
            orcamento.getCliente().getEmail(),
            orcamento.getCliente().getEnderecos()
        );

        for(var produto: orcamento.getProdutos()){

            var fornecedor = new DtoVisualizarFornecedorDentroDeProduto(
                produto.getFornecedor().getNome(),
                produto.getFornecedor().getTelefone(),
                produto.getFornecedor().getEmail(),
                produto.getFornecedor().getEnderecos()
            );

            var categoria = new DtoVisualizarCategoriaDentroDeProduto(produto.getCategoria().getNome(), produto.getCategoria().getDescricao());

            produtosDto.add(
                new DtoVisualizarProduto(
                    produto.getNome(), 
                    fornecedor, 
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

        return new DtoVisualizarOrcamento(
            orcamento.getId(),
            produtosDto,
            clienteDto,
            orcamento.getValidade(),
            orcamento.getTotal(),
            orcamento.getDesconto()
        );
    }

    public List<DtoVisualizarOrcamento> paraDtoDeVisualizar(List<Orcamento> orcamentos, List<DtoVisualizarCliente> clientesDto, List<List<DtoVisualizarProduto>> produtosDto) {
     return orcamentos.stream()
            .map(this::paraDtoDeVisualizar)
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
