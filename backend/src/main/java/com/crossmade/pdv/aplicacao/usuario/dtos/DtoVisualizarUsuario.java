package com.crossmade.pdv.aplicacao.usuario.dtos;

import com.crossmade.pdv.dominio.usuario.Papel;

public record DtoVisualizarUsuario(
    String nome,
    Papel papel
) {

}
