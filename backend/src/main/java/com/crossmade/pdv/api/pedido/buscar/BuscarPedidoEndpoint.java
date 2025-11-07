package com.crossmade.pdv.api.pedido.buscar;

import com.crossmade.pdv.aplicacao.pedido.dtos.ListaPedidoDto;
import com.crossmade.pdv.aplicacao.pedido.dtos.ModeloVisualizacaoPedido;
import com.crossmade.pdv.aplicacao.pedido.query.buscar.porId.BuscarPedidoPorIdHandler;
import com.crossmade.pdv.aplicacao.pedido.query.buscar.porId.BuscarPedidoPorIdQuery;
import com.crossmade.pdv.aplicacao.pedido.query.buscar.todos.BuscarTodosOsPedidosHandler;
import com.crossmade.pdv.aplicacao.pedido.query.buscar.todos.BuscarTodosOsPedidosQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pedidos")
public class BuscarPedidoEndpoint {

    private final BuscarPedidoPorIdHandler buscarPorIdHandler;
    private final BuscarTodosOsPedidosHandler buscarTodosOsPedidosHandler;

    public BuscarPedidoEndpoint(BuscarPedidoPorIdHandler buscarPorIdHandler, BuscarTodosOsPedidosHandler buscarTodosOsPedidosHandler) {
        this.buscarPorIdHandler = buscarPorIdHandler;
        this.buscarTodosOsPedidosHandler = buscarTodosOsPedidosHandler;
    }

    @GetMapping()
    public ResponseEntity<ListaPedidoDto> buscarTodos(@RequestParam int pagina) {
        try{
            var dto = buscarTodosOsPedidosHandler.handle(new BuscarTodosOsPedidosQuery(pagina));
            return ResponseEntity.ok(dto);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();


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
