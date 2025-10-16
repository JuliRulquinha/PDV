package com.crossmade.pdv.dominio.pedido;

import java.util.List;


public interface PedidoRepositorio {
    Pedido salvar(Pedido pedido);
    Pedido buscarPorId(Integer id);
    List<Pedido> listarTodos();
    Pedido cancelar(Integer id);
    Pedido mudarStatus(Integer id, StatusPedido status);
}
