package com.crossmade.pdv.api.orcamento.criar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.orcamento.command.fazer.FazerOrcamentoCommand;
import com.crossmade.pdv.aplicacao.orcamento.command.fazer.FazerOrcamentoHandler;
import com.crossmade.pdv.aplicacao.orcamento.dtos.ModeloVisualizacaoOrcamento;

@RestController
@RequestMapping("/api/orcamentos")
public class FazerOrcamentoEndpoint {

    private final FazerOrcamentoHandler handler;
    
    public FazerOrcamentoEndpoint(FazerOrcamentoHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ModeloVisualizacaoOrcamento> criar(@RequestBody FazerOrcamentoCommand command) {

        try{
            var dto = handler.handle(command);
            return ResponseEntity.ok(dto);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();

    }
}
