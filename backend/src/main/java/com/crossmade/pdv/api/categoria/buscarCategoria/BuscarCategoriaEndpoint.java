package com.crossmade.pdv.api.categoria.buscarCategoria;

import com.crossmade.pdv.aplicacao.categoria.dtos.ListaCategoriaDto;
import com.crossmade.pdv.aplicacao.categoria.query.buscar.BuscarTodasAsCategoriasHandler;
import com.crossmade.pdv.aplicacao.categoria.query.buscar.BuscarTodasAsCategoriasQuery;
import com.crossmade.pdv.aplicacao.produto.dtos.ListaProdutoDto;
import com.crossmade.pdv.aplicacao.produto.query.buscarTodos.BuscarTodosOsProdutosQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categorias")
public class BuscarCategoriaEndpoint {

    private final BuscarTodasAsCategoriasHandler handler;

    public BuscarCategoriaEndpoint(BuscarTodasAsCategoriasHandler handler) {
        this.handler = handler;
    }

    @GetMapping
    public ResponseEntity<ListaCategoriaDto> buscarTodos(){

        try {
            var query = new BuscarTodasAsCategoriasQuery();
            var categoriasDeDb = handler.handle(query);
            return ResponseEntity.ok(categoriasDeDb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }
}
