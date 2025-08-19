package com.crossmade.pdv.dominio.cliente;

import java.util.List;

import com.crossmade.pdv.dominio.contato.Contato;
import com.crossmade.pdv.dominio.endereco.Endereco;
import com.crossmade.pdv.dominio.pedido.Pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Contato contato;
    private Endereco endereco;
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
    

  
    public Cliente() {
    }
    public Cliente(String name, Contato contato, Endereco endereco) {
        this.name = name;
        this.contato = contato;
        this.endereco = endereco;
    }
    public Cliente(Integer id, String name, Contato contato, Endereco endereco) {
        this.id = id;
        this.name = name;
        this.contato = contato;
        this.endereco = endereco;
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
    public Contato getContato() {
        return contato;
    }
    public void setContato(Contato contato) {
        this.contato = contato;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
      public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
