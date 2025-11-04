package com.crossmade.pdv.api.cliente.buscar;

import com.crossmade.pdv.aplicacao.cliente.dtos.ListaClienteDto;
import com.crossmade.pdv.aplicacao.cliente.query.buscar.todos.BuscarClientesHandler;
import com.crossmade.pdv.aplicacao.cliente.query.buscar.todos.BuscarClientesQuery;
import com.crossmade.pdv.aplicacao.orcamento.query.buscar.porNomeContendo.BuscarPorNomeContendoHandler;
import com.crossmade.pdv.aplicacao.orcamento.query.buscar.porNomeContendo.BuscarPorNomeContendoQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.cliente.query.buscar.porId.BuscarClientePorIdHandler;
import com.crossmade.pdv.aplicacao.cliente.query.buscar.porId.BuscarClientePorIdQuery;

@RestController
@RequestMapping("/api/clientes")
public class BuscarClienteEndpoint {

    private final BuscarClientePorIdHandler buscarPorIdHandler;
    private final BuscarClientesHandler buscarClientesHandler;
    private final BuscarPorNomeContendoHandler buscarPorNomeContendoHandler;
    
    public BuscarClienteEndpoint(BuscarClientePorIdHandler buscarPorIdHandler, BuscarClientesHandler buscarClientesHandler, BuscarPorNomeContendoHandler buscarPorNomeContendoHandler) {
        this.buscarPorIdHandler = buscarPorIdHandler;
        this.buscarClientesHandler = buscarClientesHandler;
        this.buscarPorNomeContendoHandler = buscarPorNomeContendoHandler;
    }

    @GetMapping()
    public ResponseEntity<ListaClienteDto> buscarTodos(){
        try{
            var query = new BuscarClientesQuery();
            var dto = buscarClientesHandler.handle(query);
            return ResponseEntity.ok(dto);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping()
    public ResponseEntity<ListaClienteDto> buscarTodosPorNome(@RequestBody String nome){
        try{
            var query = new BuscarPorNomeContendoQuery(nome);
            var dto = buscarPorNomeContendoHandler.handle(query);
            return ResponseEntity.ok(dto);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloVisualizacaoCliente> buscarPorId(@PathVariable Integer id) {
        try{
            var dto = buscarPorIdHandler.handle(new BuscarClientePorIdQuery(id));
            return ResponseEntity.ok(dto);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
