package com.crossmade.pdv.api.cliente.buscar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.cliente.query.buscar.porId.BuscarClientePorIdHandler;
import com.crossmade.pdv.aplicacao.cliente.query.buscar.porId.BuscarClientePorIdQuery;

@RestController
@RequestMapping("/api/clientes/buscar")
public class BuscarClienteEndpoint {

    private final BuscarClientePorIdHandler buscarPorIdHandler;
    
    public BuscarClienteEndpoint(BuscarClientePorIdHandler buscarPorIdHandler) {
        this.buscarPorIdHandler = buscarPorIdHandler;
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
