package com.crossmade.pdv.aplicacao.orcamento.command.fazer;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.crossmade.pdv.aplicacao.cliente.dtos.DtoVisualizarCliente;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;


public record FazerOrcamentoCommand(
    List<DtoVisualizarProduto> produtos,
    DtoVisualizarCliente cliente,
    Date validade,
    BigDecimal total,
    int desconto
) {

}
