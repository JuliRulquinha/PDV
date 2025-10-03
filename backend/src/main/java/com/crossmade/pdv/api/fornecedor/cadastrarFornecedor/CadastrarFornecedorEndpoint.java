package com.crossmade.pdv.api.fornecedor.cadastrarFornecedor;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.fornecedor.command.cadastrar.CadastrarFornecedorCommand;
import com.crossmade.pdv.aplicacao.fornecedor.command.cadastrar.CadastrarFornecedorHandler;
import com.crossmade.pdv.dominio.fornecedor.Fornecedor;

@RestController
@RequestMapping("api/fornecedores")
public class CadastrarFornecedorEndpoint {
   
    private final CadastrarFornecedorHandler handler;

    public CadastrarFornecedorEndpoint(CadastrarFornecedorHandler handler){
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<DtoVisualizarFornecedor> cadastrar(@RequestBody CadastrarFornecedorCommand comando){
        try {
            var fornecedor = handler.handle(comando);
            return ResponseEntity.ok(fornecedor);

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
