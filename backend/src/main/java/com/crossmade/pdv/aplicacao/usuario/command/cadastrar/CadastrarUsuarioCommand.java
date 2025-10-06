package com.crossmade.pdv.aplicacao.usuario.command.cadastrar;

import com.crossmade.pdv.dominio.usuario.Papel;

public record CadastrarUsuarioCommand(
        String nome,
        String senha,
        Papel papel
) {

}
