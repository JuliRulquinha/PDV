package com.crossmade.pdv.api.produto.atualizar;

import com.crossmade.pdv.aplicacao.produto.command.atualizar.AtualizarProdutoCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crossmade.pdv.aplicacao.produto.command.atualizar.AtualizarProdutoHandler;
import com.crossmade.pdv.dominio.produto.Produto;

@RestController
@RequestMapping("api/produtos")
public class AtualizarProdutoEndpoint {

    private final AtualizarProdutoHandler handler;

    public AtualizarProdutoEndpoint(AtualizarProdutoHandler handler){
        this.handler = handler;
    }

    @PutMapping("/{id}")
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
