package com.crossmade.pdv.dominio.produto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.pedido.Pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToOne()
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    @ManyToOne()
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    private String marca;
    private String modelo;
    private int quantidade;
    private BigDecimal valorCusto;
    private BigDecimal valorVenda;
    private String imageUrl;
    private Date validade;
    private Dimensoes dimensoes;
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;

    public Produto() {
    }


    public Produto(Integer id, String nome, Fornecedor fornecedor, Categoria categoria, String marca, String modelo, int quantidade,
            BigDecimal valorCusto, BigDecimal valorVenda, String imageUrl, Date validade, Dimensoes dimensoes) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.imageUrl = imageUrl;
        this.validade = validade;
        this.dimensoes = dimensoes;
        this.fornecedor = fornecedor;
    }



    public Produto(String nome,Fornecedor fornecedor, Categoria categoria, String marca, String modelo, int quantidade, BigDecimal valorCusto,
            BigDecimal valorVenda, String imageUrl, Date validade, Dimensoes dimensoes) {
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.imageUrl = imageUrl;
        this.validade = validade;
        this.dimensoes = dimensoes;

    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getValorCusto() {
        return valorCusto;
    }
    public void setValorCusto(BigDecimal valorCusto) {
        this.valorCusto = valorCusto;
    }
    public BigDecimal getValorVenda() {
        return valorVenda;
    }
    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Date getValidade() {
        return validade;
    }
    public void setValidade(Date validade) {
        this.validade = validade;
    }
    public Dimensoes getDimensoes() {
        return dimensoes;
    }
    public void setDimensoes(Dimensoes dimensoes) {
        this.dimensoes = dimensoes;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }


    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
