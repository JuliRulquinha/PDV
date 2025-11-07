package com.crossmade.pdv.api.pedido.cancelar;

import com.crossmade.pdv.aplicacao.pedido.command.cancelar.CancelarPedidoCommand;
import com.crossmade.pdv.aplicacao.pedido.command.cancelar.CancelarPedidoHandler;
import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedidos/cancelar")
public class CancelarPedidoEndpoint {


    private final CancelarPedidoHandler handler;

    public CancelarPedidoEndpoint(CancelarPedidoHandler handler) {
        this.handler = handler;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ModeloVisualizacaoPedido> cancelar(@PathVariable Integer id){
        try{

            var command = new CancelarPedidoCommand(id);
            var resposta = handler.handle(command);
            return ResponseEntity.ok(resposta);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }
}
