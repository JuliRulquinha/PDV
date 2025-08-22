package com.crossmade.pdv.dominio.cliente;

import java.util.ArrayList;
import java.util.List;

import com.crossmade.pdv.dominio.endereco.Endereco;
import com.crossmade.pdv.dominio.orcamento.Orcamento;
import com.crossmade.pdv.dominio.pedido.Pedido;

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
@Table(name = "clientes")
public class Cliente {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String telefone;
    private String email;
    @ElementCollection
    @CollectionTable(name = "cliente_enderecos",
            joinColumns = @JoinColumn(name = "cliente_id"))
    private List<Endereco> enderecos = new ArrayList<>();
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "cliente")
    private List<Orcamento> orcamentos;
    

  
    public Cliente() {
    }
    public Cliente(String name, String telefone, String email, Endereco endereco) {
        this.name = name;
        this.telefone = telefone;
        this.email = email;

    }

      public Cliente( String name, String telefone, String email, List<Endereco> enderecos) {
        
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.enderecos = enderecos;
    }

    public Cliente(Integer id, String name, String telefone, String email, List<Endereco> enderecos) {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.enderecos = enderecos;
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
      public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
