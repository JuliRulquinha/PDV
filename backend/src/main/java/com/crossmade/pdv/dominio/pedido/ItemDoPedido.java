package com.crossmade.pdv.dominio.pedido;

import com.crossmade.pdv.dominio.produto.Produto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_do_pedido")
public class ItemDoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal total;


    public ItemDoPedido() {
    }

    public ItemDoPedido(Pedido pedido, Produto produto, int quantidade, BigDecimal valorUnitario, BigDecimal total) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.total = total;
    }

    public ItemDoPedido(Integer id, Pedido pedido, Produto produto, int quantidade, BigDecimal valorUnitario, BigDecimal total) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
