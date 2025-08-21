package com.crossmade.pdv.infraestrutura.pedido;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.crossmade.pdv.dominio.pedido.Pedido;
import com.crossmade.pdv.dominio.pedido.PedidoRepositorio;


@Repository
public class PedidoRepositorioIplm implements PedidoRepositorio{

     private final SpringDataPedidoRepositorio repositorio;

    public PedidoRepositorioIplm(SpringDataPedidoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
       return repositorio.save(pedido);
    }

    @Override
    public Pedido buscarPorId(Integer id) {
       return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<Pedido> listarTodos() {
        return repositorio.findAll();
    }

    @Override
    public void cancelar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelar'");
    }

}
