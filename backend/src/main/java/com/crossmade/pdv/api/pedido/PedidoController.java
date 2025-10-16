package com.crossmade.pdv.api.pedido;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.pedido.command.criar.CriarPedidoCommand;
import com.crossmade.pdv.aplicacao.pedido.command.criar.CriarPedidoHandler;
import com.crossmade.pdv.aplicacao.pedido.dtos.DtoVisualizarPedido;
import com.crossmade.pdv.aplicacao.pedido.query.buscar.BuscarPedidoPorIdHandler;
import com.crossmade.pdv.aplicacao.pedido.query.buscar.BuscarPedidoPorIdQuery;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final CriarPedidoHandler cadastrarHandler;
    private final BuscarPedidoPorIdHandler buscarPorIdHandler;

    public PedidoController(CriarPedidoHandler cadastrarHandler, BuscarPedidoPorIdHandler buscarPorIdHandler) {
        this.cadastrarHandler = cadastrarHandler;
        this.buscarPorIdHandler = buscarPorIdHandler;
    }

    @PostMapping
    public ResponseEntity<DtoVisualizarPedido> cadastrar(@RequestBody CriarPedidoCommand command) {
        var dto = cadastrarHandler.handle(command);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoVisualizarPedido> buscarPorId(@PathVariable Integer id) {
        var dto = buscarPorIdHandler.handle(new BuscarPedidoPorIdQuery(id));
        return ResponseEntity.ok(dto);
    }
}
