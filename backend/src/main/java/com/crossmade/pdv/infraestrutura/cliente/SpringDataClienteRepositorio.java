package com.crossmade.pdv.infraestrutura.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.cliente.Cliente;

public interface SpringDataClienteRepositorio extends JpaRepository<Cliente, Integer>{

  
}
