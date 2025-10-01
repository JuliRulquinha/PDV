package com.crossmade.pdv.api.fornecedor.buscarFornecedor;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.ListaFornecedoresDto;
import com.crossmade.pdv.aplicacao.fornecedor.query.buscarTodosOsFornecedores.BuscarTodosOsFornecedoresHandler;
import com.crossmade.pdv.aplicacao.fornecedor.query.buscarTodosOsFornecedores.BuscarTodosOsFornecedoresQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fornecedores")
public class BuscarFornecedorEndpoint {
    private final BuscarTodosOsFornecedoresHandler handler;

    public BuscarFornecedorEndpoint(BuscarTodosOsFornecedoresHandler handler) {
        this.handler = handler;
    }

    @GetMapping
    public ResponseEntity<ListaFornecedoresDto> buscarTodos(){

        try {
            var query = new BuscarTodosOsFornecedoresQuery();
            var fornecedorDoDb = handler.handle(query);
            return ResponseEntity.ok(fornecedorDoDb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }
}
