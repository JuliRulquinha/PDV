package com.crossmade.pdv.api.cliente.cadastrarCliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.infraestrutura.cliente.ClienteRepositorioIplm;


@RestController
@RequestMapping("api/clientes/cadastrar")
public class CadastrarClienteEndpoint {

    private final ClienteRepositorioIplm repositorio;

    public CadastrarClienteEndpoint(ClienteRepositorioIplm repositorio){
        this.repositorio = repositorio;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
        try {
            var clienteSalvo = repositorio.salvar(cliente);
            return ResponseEntity.ok(clienteSalvo);

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
