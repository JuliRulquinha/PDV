package com.crossmade.pdv.dominio.fornecedor;

import java.util.ArrayList;
import java.util.List;

import com.crossmade.pdv.dominio.endereco.Endereco;
import com.crossmade.pdv.dominio.produto.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String telefone;
    private String email;
    @ElementCollection
    @CollectionTable(name = "fornecedor_enderecos",
            joinColumns = @JoinColumn(name = "fornecedor_id"))
    private List<Endereco> enderecos = new ArrayList<>();
    @OneToMany(mappedBy = "fornecedor")
    @JsonIgnore
    private List<Produto> produtos;

    public Fornecedor() {
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Fornecedor(Integer id, String name, String telefone, String email) {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
    }



    public Fornecedor(String name, String telefone, String email) {
        this.name = name;
        this.telefone = telefone;
        this.email = email;
    }



    public Fornecedor(String name, String telefone, String email,  List<Produto> produtos) {
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.produtos = produtos;
    }

    public Fornecedor(Integer id, String name, String telefone, String email,  List<Produto> produtos) {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.produtos = produtos;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
}
