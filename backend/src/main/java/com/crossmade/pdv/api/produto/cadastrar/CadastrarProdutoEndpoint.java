package com.crossmade.pdv.api.produto.cadastrar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@RestController
@RequestMapping("api/produtos")
public class CadastrarProdutoEndpoint {

    private final ProdutoRepositorioIplm repositorio;

    public CadastrarProdutoEndpoint(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto){
        try {
            var produtoSalvo = repositorio.salvar(produto);
            return ResponseEntity.ok(produtoSalvo);

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
