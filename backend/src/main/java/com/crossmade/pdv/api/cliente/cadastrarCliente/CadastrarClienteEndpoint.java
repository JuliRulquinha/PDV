package com.crossmade.pdv.api.cliente.cadastrarCliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.cliente.command.cadastrar.CadastrarClienteCommand;
import com.crossmade.pdv.aplicacao.cliente.command.cadastrar.CadastrarClienteHandler;
import com.crossmade.pdv.dominio.cliente.Cliente;



@RestController
@RequestMapping("api/clientes")
public class CadastrarClienteEndpoint {

    private final CadastrarClienteHandler handler;

    public CadastrarClienteEndpoint(CadastrarClienteHandler handler){
        this.handler = handler;
        
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody CadastrarClienteCommand comando){
        try {
            var cliente = handler.handle(comando);
            return ResponseEntity.ok(cliente);

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
