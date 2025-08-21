package com.crossmade.pdv.infraestrutura.pedido;

import java.util.List;
import java.util.Optional;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public Optional<Pedido> buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Pedido> listarTodas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodas'");
    }

    @Override
    public void cancelar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelar'");
    }

}
