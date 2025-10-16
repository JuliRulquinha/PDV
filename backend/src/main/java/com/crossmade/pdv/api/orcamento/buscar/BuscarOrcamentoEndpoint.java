package com.crossmade.pdv.api.orcamento.buscar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.orcamento.dtos.ModeloVisualizacaoOrcamento;
import com.crossmade.pdv.aplicacao.orcamento.query.buscar.BuscarOrcamentoPorIdHandler;
import com.crossmade.pdv.aplicacao.orcamento.query.buscar.BuscarOrcamentoPorIdQuery;

@RestController
@RequestMapping("/api/orcamentos/buscar")
public class BuscarOrcamentoEndpoint {

    private final BuscarOrcamentoPorIdHandler handler;

    public BuscarOrcamentoEndpoint(BuscarOrcamentoPorIdHandler handler) {
       
        this.handler = handler;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloVisualizacaoOrcamento> buscarPorId(@PathVariable Integer id) {
        try{
            var dto = handler.handle(new BuscarOrcamentoPorIdQuery(id));
            return ResponseEntity.ok(dto);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();


    }
}
