package com.crossmade.pdv.dominio.pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepositorio {
    Pedido salvar(Pedido pedido);
    Optional<Pedido> buscarPorId(Integer id);
    List<Pedido> listarTodas();
    void cancelar(Integer id);
}
