package com.crossmade.pdv.aplicacao.categoria.dtos;

import com.crossmade.pdv.dominio.categoria.Categoria;

import java.util.List;

public record ListaCategoriaDto(
        List<Categoria> categorias
) {
}
