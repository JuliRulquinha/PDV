package com.crossmade.pdv.api.orcamento.buscar;

import com.crossmade.pdv.aplicacao.orcamento.dtos.ListaOrcamentoDto;
import com.crossmade.pdv.aplicacao.orcamento.query.buscar.todos.BuscarTodosOsOrcamentosHandler;
import com.crossmade.pdv.aplicacao.orcamento.query.buscar.todos.BuscarTodosOrcamentosQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crossmade.pdv.aplicacao.orcamento.dtos.ModeloVisualizacaoOrcamento;
import com.crossmade.pdv.aplicacao.orcamento.query.buscar.porId.BuscarOrcamentoPorIdHandler;
import com.crossmade.pdv.aplicacao.orcamento.query.buscar.porId.BuscarOrcamentoPorIdQuery;

@RestController
@RequestMapping("/api/orcamentos")
public class BuscarOrcamentoEndpoint {

    private final BuscarOrcamentoPorIdHandler buscarOrcamentoPorIdHandler;
    private final BuscarTodosOsOrcamentosHandler buscarTodosOsOrcamentosHandler;
    public BuscarOrcamentoEndpoint(BuscarOrcamentoPorIdHandler buscarOrcamentoPorIdHandler, BuscarTodosOsOrcamentosHandler buscarTodosOsOrcamentosHandler, BuscarTodosOsOrcamentosHandler buscarTodosOsOrcamentosHandler1) {
       
        this.buscarOrcamentoPorIdHandler = buscarOrcamentoPorIdHandler;
        this.buscarTodosOsOrcamentosHandler = buscarTodosOsOrcamentosHandler1;
    }

    @GetMapping()
    public ResponseEntity<ListaOrcamentoDto> buscarTodos(@RequestParam int pagina) {
        try{
            var dtos = buscarTodosOsOrcamentosHandler.handle(new BuscarTodosOrcamentosQuery(pagina));
            return ResponseEntity.ok(dtos);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();


    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloVisualizacaoOrcamento> buscarPorId(@PathVariable Integer id) {
        try{
            var dto = buscarOrcamentoPorIdHandler.handle(new BuscarOrcamentoPorIdQuery(id));
            return ResponseEntity.ok(dto);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();


    }
}
