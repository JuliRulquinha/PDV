package com.crossmade.pdv.dominio.fornecedor;

import java.util.ArrayList;
import java.util.List;


import com.crossmade.pdv.dominio.endereco.Endereco;
import com.crossmade.pdv.dominio.produto.Produto;

import jakarta.persistence.*;

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
    private Endereco endereco;
    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos;

    public Fornecedor() {
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Fornecedor(Integer id, String name, String telefone, String email, Endereco endereco) {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }



    public Fornecedor(String name, String telefone, String email, Endereco endereco) {
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }



    public Fornecedor(String name, String telefone, String email, Endereco endereco, List<Produto> produtos) {
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.produtos = produtos;
    }

    public Fornecedor(Integer id, String name, String telefone, String email, Endereco endereco, List<Produto> produtos) {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
}
