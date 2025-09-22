package com.crossmade.pdv.aplicacao.produto.command.atualizar;

import java.math.BigDecimal;
import java.sql.Date;

import com.crossmade.pdv.dominio.produto.Dimensoes;

public record AtualizarProdutoCommand (
    String nome,
    Integer categoria_id,
    Integer fornecedor_id,
    String marca,
    String modelo,
    int quantidade,
    BigDecimal valorCusto,
    BigDecimal valorVenda,
    String imageUrl,
    Date validade,
    Dimensoes dimensoes
){

}
