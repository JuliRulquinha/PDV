package com.crossmade.pdv.aplicacao.categoria.dtos;

import com.crossmade.pdv.dominio.produto.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;

import java.util.List;

public record DtoCadastroCategoria(
         String nome,
         String descricao

) {
}
