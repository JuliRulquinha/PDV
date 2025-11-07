package com.crossmade.pdv.api.orcamento.cancelar;

import com.crossmade.pdv.aplicacao.orcamento.command.cancelar.CancelarOrcamentoCommand;
import com.crossmade.pdv.aplicacao.orcamento.command.cancelar.CancelarOrcamentoHandler;
import com.crossmade.pdv.aplicacao.orcamento.dtos.ModeloVisualizacaoOrcamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancelarOrcamentoEndPoint {

    private final CancelarOrcamentoHandler handler;

    public CancelarOrcamentoEndPoint(CancelarOrcamentoHandler handler) {
        this.handler = handler;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ModeloVisualizacaoOrcamento> cancelar(@PathVariable Integer id){

        try{
            var command = new CancelarOrcamentoCommand(id);
            var resposta = handler.handle(command);
            return ResponseEntity.ok(resposta);

        } catch(Exception e) {
            System.out.println(e.getMessage());

        }
        return ResponseEntity.badRequest().build();
    }
}
