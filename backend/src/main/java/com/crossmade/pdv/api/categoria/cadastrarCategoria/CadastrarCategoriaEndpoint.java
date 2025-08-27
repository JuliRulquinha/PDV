package com.crossmade.pdv.api.categoria.cadastrarCategoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.categoria.command.cadastrar.CadastrarCategoriaCommand;
import com.crossmade.pdv.aplicacao.categoria.command.cadastrar.CadastrarCategoriaHandler;
import com.crossmade.pdv.dominio.categoria.Categoria;


@RestController
@RequestMapping("api/categorias")
public class CadastrarCategoriaEndpoint {
  

    private final CadastrarCategoriaHandler handler;

    public CadastrarCategoriaEndpoint(CadastrarCategoriaHandler handler){
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody CadastrarCategoriaCommand comando){
        try {
            var categoria = handler.handle(comando);
            return ResponseEntity.ok(categoria);

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
