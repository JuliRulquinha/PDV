package com.crossmade.pdv.aplicacao.pedido.mapper;

import java.util.ArrayList;
import java.util.List;

import com.crossmade.pdv.aplicacao.categoria.dtos.ModeloVisualizacaoCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ModeloVisualizacaoFornecedorDentroDeProduto;
import com.crossmade.pdv.dominio.endereco.Endereco;
import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.pedido.Pedido;

@Service
public class MapperPedido {
    public ModeloVisualizacaoPedido paraModeloVisualizacao(Pedido pedido) {

        List<ModeloVisualizacaoProduto> produtosDto = new ArrayList<>();
        List<Endereco> enderecos = pedido.getCliente().getEnderecos();
        ModeloVisualizacaoCliente clienteDto = new ModeloVisualizacaoCliente(
                pedido.getCliente().getnome(),
                pedido.getCliente().getTelefone(),
                pedido.getCliente().getEmail(),
                enderecos
        );

        for(var produto: pedido.getProdutos()){

            var fornecedor = new ModeloVisualizacaoFornecedorDentroDeProduto(
                    produto.getFornecedor().getNome(),
                    produto.getFornecedor().getTelefone(),
                    produto.getFornecedor().getEmail(),
                    produto.getFornecedor().getEnderecos()
            );

            var categoria = new ModeloVisualizacaoCategoriaDentroDeProduto(produto.getCategoria().getNome(), produto.getCategoria().getDescricao());

            produtosDto.add(
                    new ModeloVisualizacaoProduto(
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

        return new ModeloVisualizacaoPedido(
            pedido.getId(),
            produtosDto,
            clienteDto,
            pedido.getValidade(),
            pedido.getTotal(),
            pedido.getDesconto()
        );
    }
}
