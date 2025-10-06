package com.crossmade.pdv.aplicacao.usuario.dtos;

import com.crossmade.pdv.dominio.usuario.Papel;

public record DtoCadastrarUsuario(
    String nome,
    String senha,
    Papel papel
) {

}
