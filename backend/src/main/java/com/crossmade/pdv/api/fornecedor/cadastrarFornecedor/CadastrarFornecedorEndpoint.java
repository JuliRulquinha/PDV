package com.crossmade.pdv.api.fornecedor.cadastrarFornecedor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.infraestrutura.fornecedor.FornecedorRepositorioIplm;

@RestController
@RequestMapping("api/fornecedores/cadastrar")
public class CadastrarFornecedorEndpoint {
    
    private final FornecedorRepositorioIplm repositorio;

    public CadastrarFornecedorEndpoint(FornecedorRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    @PostMapping
    public ResponseEntity<Fornecedor> cadastrar(@RequestBody Fornecedor fornecedor){
        try {
            var fornecedorSalvo = repositorio.salvar(fornecedor);
            return ResponseEntity.ok(fornecedorSalvo);

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
