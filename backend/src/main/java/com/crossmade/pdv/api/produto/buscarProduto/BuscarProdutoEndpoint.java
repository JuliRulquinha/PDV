package com.crossmade.pdv.api.produto.buscarProduto;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.infraestrutura.produto.ProdutoRepositorioIplm;

@RestController
@RequestMapping("api/produtos")
public class BuscarProdutoEndpoint {

    private final ProdutoRepositorioIplm repositorio;

    public BuscarProdutoEndpoint(ProdutoRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }


    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(){

        try {
            var produtosDeDb = repositorio.buscarTodos();
            return ResponseEntity.ok(produtosDeDb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id){

        try {
            var produtoDeDb = repositorio.buscarPorId(id);
            return ResponseEntity.ok(produtoDeDb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/nome")
    public ResponseEntity<List<Produto>>buscarPorNome(@RequestParam String valor) { 
        try {
            var produtoDeDb = repositorio.buscarPorNome(valor);
            return ResponseEntity.ok(produtoDeDb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Produto>>buscarPorCategoria(@RequestParam String valor) { 
        try {
            var produtoDeDb = repositorio.buscarPorCategoria(valor);
            return ResponseEntity.ok(produtoDeDb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
