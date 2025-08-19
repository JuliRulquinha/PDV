package com.crossmade.pdv.dominio.pedido;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.produto.Produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "pedido_id")
            },inverseJoinColumns = {
                    @JoinColumn(name = "produto_id")
            }
    )
    private List<Produto> produtos;
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Date validade;
    private BigDecimal total;
    private int desconto;

    public Pedido() {
    }

    public Pedido(List<Produto> produtos, Cliente cliente, Date validade, BigDecimal total, int desconto) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.validade = validade;
        this.total = total;
        this.desconto = desconto;
    }
    
    public Pedido(Integer id, List<Produto> produtos, Cliente cliente, Date validade, BigDecimal total, int desconto) {
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
