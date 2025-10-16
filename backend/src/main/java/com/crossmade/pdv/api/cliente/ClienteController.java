package com.crossmade.pdv.api.cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.cliente.command.cadastrar.CadastrarClienteCommand;
import com.crossmade.pdv.aplicacao.cliente.command.cadastrar.CadastrarClienteHandler;
import com.crossmade.pdv.aplicacao.cliente.dtos.DtoVisualizarCliente;
import com.crossmade.pdv.aplicacao.cliente.query.buscar.porId.BuscarClientePorIdHandler;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final CadastrarClienteHandler cadastrarHandler;
    private final BuscarClientePorIdHandler buscarPorIdHandler;

    public ClienteController(CadastrarClienteHandler cadastrarHandler, BuscarClientePorIdHandler buscarPorIdHandler) {
        this.cadastrarHandler = cadastrarHandler;
        this.buscarPorIdHandler = buscarPorIdHandler;
    }

    @PostMapping
    public ResponseEntity<DtoVisualizarCliente> cadastrar(@RequestBody CadastrarClienteCommand command) {
        var dto = cadastrarHandler.handle(command);
        return ResponseEntity.ok(dto);
    }

   
}
