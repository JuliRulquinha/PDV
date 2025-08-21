package com.crossmade.pdv.api.categoria.cadastrarCategoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.dominio.categoria.Categoria;
import com.crossmade.pdv.infraestrutura.categoria.CategoriaRepositorioIplm;

@RestController
@RequestMapping("api/categorias/cadastrar")
public class CadastrarCategoriaEndpoint {
    private final CategoriaRepositorioIplm repositorio;

    public CadastrarCategoriaEndpoint(CategoriaRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria){
        try {
            var categoriaSalva = repositorio.salvar(categoria);
            return ResponseEntity.ok(categoriaSalva);

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
