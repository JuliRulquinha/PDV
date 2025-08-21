package com.crossmade.pdv.infraestrutura.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.pedido.Pedido;

public interface SpringDataPedidoRepositorio extends JpaRepository<Pedido, Integer>{

}
