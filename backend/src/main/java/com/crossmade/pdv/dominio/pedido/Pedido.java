package com.crossmade.pdv.dominio.pedido;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.produto.Produto;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDoPedido> itens;
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Date validade;
    private BigDecimal total;
    private int desconto;
    private StatusPedido status;

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }



    public Pedido() {
    }

    public Pedido(List<ItemDoPedido> itens, Cliente cliente, Date validade, BigDecimal total, int desconto) {
        this.itens = itens;
        this.cliente = cliente;
        this.validade = validade;
        this.total = total;
        this.desconto = desconto;
        this.status = StatusPedido.CRIADO;
    }

    public Pedido(List<ItemDoPedido> itens, Date validade, BigDecimal total, int desconto) {
        this.itens = itens;
        this.validade = validade;
        this.total = total;
        this.desconto = desconto;
        this.status = StatusPedido.CRIADO;
    }
    
    public Pedido(Integer id, List<ItemDoPedido> itens, Cliente cliente, Date validade, BigDecimal total, int desconto, StatusPedido status) {
        this.id = id;
        this.itens = itens;
        this.cliente = cliente;
        this.validade = validade;
        this.total = total;
        this.desconto = desconto;
        this.status = status;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<ItemDoPedido> getItens() {
        return itens;
    }
    public void setItens(List<ItemDoPedido> itens) {
        this.itens = itens;
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
