package com.crossmade.pdv.api.produto.cadastrar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.produto.command.cadastrar.CadastrarProdutoCommand;
import com.crossmade.pdv.aplicacao.produto.command.cadastrar.CadastrarProdutoHandler;
import com.crossmade.pdv.dominio.produto.Produto;


@RestController
@RequestMapping("api/produtos")
public class CadastrarProdutoEndpoint {

    private final CadastrarProdutoHandler handler;

    public CadastrarProdutoEndpoint(CadastrarProdutoHandler handler){
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody CadastrarProdutoCommand comando){
        try {
            var produto = handler.handle(comando);
            return ResponseEntity.ok(produto);

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
