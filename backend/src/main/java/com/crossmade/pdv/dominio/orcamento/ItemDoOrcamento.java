package com.crossmade.pdv.dominio.orcamento;

import com.crossmade.pdv.dominio.produto.Produto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_do_orcamento")
public class ItemDoOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id-orcamento")
    private Orcamento orcamento;

    @ManyToOne
    @JoinColumn(name = "id-produto")
    private Produto produto;
    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal total;

    public ItemDoOrcamento() {
    }

    public ItemDoOrcamento(Orcamento orcamento, Produto produto, int quantidade, BigDecimal valorUnitario, BigDecimal total) {
        this.orcamento = orcamento;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.total = total;
    }

    public ItemDoOrcamento(Integer id, Orcamento orcamento, Produto produto, int quantidade, BigDecimal valorUnitario, BigDecimal total) {
        this.id = id;
        this.orcamento = orcamento;
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

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
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
