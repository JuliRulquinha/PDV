package com.crossmade.pdv.infraestrutura.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.cliente.Cliente;

import java.util.List;

public interface SpringDataClienteRepositorio extends JpaRepository<Cliente, Integer>{
    List<Cliente> findByNomeContaining(String nome);
    Cliente findByNome(String nome);
}
