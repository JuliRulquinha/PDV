package com.crossmade.pdv.dominio.orcamento;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.produto.Produto;

import jakarta.persistence.*;

@Entity
@Table(name = "orcamentos")
public class Orcamento {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Produto> produtos;
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Date validade;
    private BigDecimal total;
    private int desconto;

    

    public Orcamento() {
    }
    public Orcamento(List<Produto> produtos, Cliente cliente, Date validade, BigDecimal total, int desconto) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.validade = validade;
        this.total = total;
        this.desconto = desconto;
    }
    public Orcamento(Integer id, List<Produto> produtos, Cliente cliente, Date validade, BigDecimal total,
            int desconto) {
        this.id = id;
        this.produtos = produtos;
        this.cliente = cliente;
        this.validade = validade;
        this.total = total;
        this.desconto = desconto;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Date getValidade() {
        return validade;
    }
    public void setValidade(Date validade) {
        this.validade = validade;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public int getDesconto() {
        return desconto;
    }
    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    
}
