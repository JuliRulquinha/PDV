package com.crossmade.pdv.api.produto.buscarProduto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.produto.query.buscarTodos.BuscarTodosOsProdutosHandler;
import com.crossmade.pdv.aplicacao.produto.query.buscarTodos.BuscarTodosOsProdutosQuery;
import com.crossmade.pdv.aplicacao.produto.query.por_categoria.BuscarPorCategoriaHandler;
import com.crossmade.pdv.aplicacao.produto.query.por_categoria.BuscarPorCategoriaQuery;
import com.crossmade.pdv.aplicacao.produto.query.por_id.BuscarPorIdHandler;
import com.crossmade.pdv.aplicacao.produto.query.por_id.BuscarPorIdQuery;
import com.crossmade.pdv.aplicacao.produto.query.por_nome.BuscarPorNomeHandler;
import com.crossmade.pdv.aplicacao.produto.query.por_nome.BuscarPorNomeQuery;
import com.crossmade.pdv.dominio.produto.Produto;

@RestController
@RequestMapping("api/produtos")
public class BuscarProdutoEndpoint {

    public BuscarProdutoEndpoint(BuscarPorIdHandler buscarPorIdHandler, 
                                 BuscarTodosOsProdutosHandler buscarTodosOsProdutosHandler,
                                 BuscarPorNomeHandler buscarPorNomeHandler,
                                 BuscarPorCategoriaHandler buscarPorCategoriaHandler
    ) {
        this.buscarPorIdHandler = buscarPorIdHandler;
        this.buscarTodosOsProdutosHandler = buscarTodosOsProdutosHandler;
        this.buscarPorNomeHandler = buscarPorNomeHandler;
        this.buscarPorCategoriaHandler = buscarPorCategoriaHandler;
    }

    private final BuscarTodosOsProdutosHandler buscarTodosOsProdutosHandler;
    private final BuscarPorCategoriaHandler buscarPorCategoriaHandler;
    private final BuscarPorNomeHandler buscarPorNomeHandler;
    private final BuscarPorIdHandler buscarPorIdHandler;


    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(@RequestParam int pagina){

        try {
            var query = new BuscarTodosOsProdutosQuery(pagina);
            var produtosDeDb = buscarTodosOsProdutosHandler.handle(query);
            return ResponseEntity.ok(produtosDeDb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id){

        try {
            var query = new BuscarPorIdQuery(id);
            var produtoDeDb = buscarPorIdHandler.handle(query);
            return ResponseEntity.ok(produtoDeDb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/nome")
    public ResponseEntity<List<Produto>>buscarPorNome(@RequestParam String nome) {
        try {
            var query = new BuscarPorNomeQuery(nome);
            var produtoDeDb = buscarPorNomeHandler.handle(query);
            return ResponseEntity.ok(produtoDeDb);
        } catch (Exception e) {
            e.printStackTrace(); // melhor para debug
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Produto>>buscarPorCategoria(@RequestParam BuscarPorCategoriaQuery query) { 
        try {
            var produtoDeDb = buscarPorCategoriaHandler.handle(query);
            return ResponseEntity.ok(produtoDeDb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
