package com.crossmade.pdv.api.usuario.buscar;

import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;
import com.crossmade.pdv.aplicacao.usuario.query.buscar.BuscarUsuarioPorIdHandler;
import com.crossmade.pdv.aplicacao.usuario.query.buscar.BuscarUsuarioPorIdQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class BuscarUsuarioPorIdEndpoint {

    private final BuscarUsuarioPorIdHandler handler;

    public BuscarUsuarioPorIdEndpoint(BuscarUsuarioPorIdHandler handler) {
        this.handler = handler;
    }

    @GetMapping()
    public ResponseEntity<DtoVisualizarUsuario> buscarPorId(@PathVariable Integer id){
        try{
            var query = new BuscarUsuarioPorIdQuery(id);
            var response = handler.handle(query);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }
}
