package com.crossmade.pdv.api.usuario.cadastrar;

import com.crossmade.pdv.aplicacao.usuario.command.cadastrar.CadastrarUsuarioCommand;
import com.crossmade.pdv.aplicacao.usuario.command.cadastrar.CadastrarUsuarioHandler;
import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuarios")
public class CadastrarUsuarioEndpoint {

    private final CadastrarUsuarioHandler handler;

    public CadastrarUsuarioEndpoint(CadastrarUsuarioHandler handler) {
        this.handler = handler;
    }

    @PostMapping()
    public ResponseEntity<DtoVisualizarUsuario> cadastrar(@RequestBody CadastrarUsuarioCommand command){
        try{
            var response = handler.handle(command);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }
}
