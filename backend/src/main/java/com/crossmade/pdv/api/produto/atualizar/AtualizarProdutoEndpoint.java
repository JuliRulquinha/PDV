package com.crossmade.pdv.api.produto.atualizar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.crossmade.pdv.aplicacao.produto.command.atualizar.AtualizarProdutoHandler;
import com.crossmade.pdv.dominio.produto.Produto;

@RestController
public class AtualizarProdutoEndpoint {
private final AtualizarProdutoHandler handler;

    public AtualizarProdutoEndpoint(AtualizarProdutoHandler handler){
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody AtualizarProdutoCommand comando){
        try {
            var produto = handler.handle(id, comando);
            return ResponseEntity.ok(produto);

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
