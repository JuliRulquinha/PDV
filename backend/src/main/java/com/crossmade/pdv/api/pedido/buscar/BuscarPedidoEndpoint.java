package com.crossmade.pdv.api.pedido.buscar;

import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.aplicacao.pedido.query.buscar.BuscarPedidoPorIdHandler;
import com.crossmade.pdv.aplicacao.pedido.query.buscar.BuscarPedidoPorIdQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedidos")
public class BuscarPedidoEndpoint {

    private final BuscarPedidoPorIdHandler buscarPorIdHandler;

    public BuscarPedidoEndpoint(BuscarPedidoPorIdHandler buscarPorIdHandler) {

        this.buscarPorIdHandler = buscarPorIdHandler;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloVisualizacaoPedido> buscarPorId(@PathVariable Integer id) {

        try{
            var dto = buscarPorIdHandler.handle(new BuscarPedidoPorIdQuery(id));
            return ResponseEntity.ok(dto);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();


    }
}
