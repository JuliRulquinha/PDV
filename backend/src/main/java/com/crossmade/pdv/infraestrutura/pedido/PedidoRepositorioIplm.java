package com.crossmade.pdv.infraestrutura.pedido;

import java.util.List;


import com.crossmade.pdv.dominio.pedido.StatusPedido;
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
    public List<Pedido> listarTodos(int pagina) {
        return repositorio.paginar(pagina);
    }

    @Override
    public Pedido cancelar(Integer id) {
        var pedidoDoDb = repositorio.findById(id).orElse(null);
        pedidoDoDb.setStatus(StatusPedido.CANCELADO);
        return repositorio.save(pedidoDoDb);
    }

    @Override
    public Pedido mudarStatus(Integer id, StatusPedido status) {
        var pedidoDoDb = repositorio.findById(id).orElse(null);
        pedidoDoDb.setStatus(status);
        return repositorio.save(pedidoDoDb);
    }

    @Override
    public int retornarContagem() {
        return repositorio.getCount();
    }
}
