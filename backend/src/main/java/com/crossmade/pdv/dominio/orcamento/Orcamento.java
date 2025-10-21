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
    @OneToMany(mappedBy = "orcamento")
    private List<ItemDoOrcamento> itens;
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Date validade;
    private BigDecimal total;
    private int desconto;
    private StatusOcamento status;

    public StatusOcamento getStatus() {
        return status;
    }

    public void setStatus(StatusOcamento status) {
        this.status = status;
    }

    public Orcamento() {
    }
    public Orcamento(List<ItemDoOrcamento> itens, Cliente cliente, Date validade, BigDecimal total, int desconto) {
        this.itens = itens;
        this.cliente = cliente;
        this.validade = validade;
        this.total = total;
        this.desconto = desconto;
        this.status = StatusOcamento.CRIADO;
    }
    public Orcamento(Integer id, List<ItemDoOrcamento> itens, Cliente cliente, Date validade, BigDecimal total,
            int desconto, StatusOcamento status) {
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
    public List<ItemDoOrcamento> getItens() {
        return itens;
    }
    public void setItens(List<ItemDoOrcamento> itens) {
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
