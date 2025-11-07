package com.crossmade.pdv.api.pedido.criar;

import com.crossmade.pdv.aplicacao.pedido.command.criar.CriarPedidoCommand;
import com.crossmade.pdv.aplicacao.pedido.command.criar.CriarPedidoHandler;
import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedidos")
public class CriarPedidoEndpoint {

    private final CriarPedidoHandler handler;

    public CriarPedidoEndpoint(CriarPedidoHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ModeloVisualizacaoPedido> criar(@RequestBody CriarPedidoCommand command) {

        try{
            var dto = handler.handle(command);
            return ResponseEntity.ok(dto);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();


    }
}
