package com.crossmade.pdv.aplicacao.pedido.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crossmade.pdv.aplicacao.categoria.dtos.ModeloVisualizacaoCategoriaDentroDeProduto;
import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ModeloVisualizacaoFornecedorDentroDeProduto;
import com.crossmade.pdv.aplicacao.pedido.command.criar.CriarPedidoCommand;
import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.endereco.Endereco;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.pedido.Pedido;
import com.crossmade.pdv.dominio.produto.Produto;

@Service
public class MapperPedido {
    public ModeloVisualizacaoPedido paraModeloVisualizacao(Pedido pedido) {

        List<ModeloVisualizacaoProduto> produtosDto = new ArrayList<>();
        List<Endereco> enderecos = pedido.getCliente().getEnderecos();
        ModeloVisualizacaoCliente clienteDto = new ModeloVisualizacaoCliente(
                pedido.getCliente().getId(),
                pedido.getCliente().getnome(),
                pedido.getCliente().getTelefone(),
                pedido.getCliente().getEmail(),
                enderecos
        );

        for(var produto: pedido.getProdutos()){

            var fornecedor = new ModeloVisualizacaoFornecedorDentroDeProduto(
                    produto.getFornecedor().getId(),
                    produto.getFornecedor().getNome(),
                    produto.getFornecedor().getTelefone(),
                    produto.getFornecedor().getEmail(),
                    produto.getFornecedor().getEnderecos()
            );

            var categoria = new ModeloVisualizacaoCategoriaDentroDeProduto(produto.getCategoria().getId(), produto.getCategoria().getNome(), produto.getCategoria().getDescricao());

            produtosDto.add(
                    new ModeloVisualizacaoProduto(
                        produto.getId(),
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

    public List<ModeloVisualizacaoPedido> paraListaDeModelos(List<Pedido> pedidos){
        return pedidos.stream().map(this::paraModeloVisualizacao).toList();
    }

    public Pedido paraDominio(CriarPedidoCommand modelo){

        List<Produto> produtos = new ArrayList<>();

        for(var produto: modelo.produtos()){

            var fornecedor = new Fornecedor(
                    produto.fornecedor().nome(),
                    produto.fornecedor().telefone(),
                    produto.fornecedor().email()
            );

            var categoria = new Categoria(produto.categoria().nome(), produto.categoria().descricao());

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
                    )
            );
        }

        var cliente = new Cliente(modelo.cliente().nome(), modelo.cliente().telefone(), modelo.cliente().email());

        return new Pedido(
                produtos,
                cliente,
                modelo.validade(),
                modelo.total(),
                modelo.desconto()
        );
    }
}
