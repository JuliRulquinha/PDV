package com.crossmade.pdv.aplicacao.orcamento.command.fazer;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.crossmade.pdv.aplicacao.cliente.dtos.ModeloVisualizacaoCliente;
import com.crossmade.pdv.aplicacao.produto.dtos.ModeloVisualizacaoProduto;
import com.crossmade.pdv.dominio.orcamento.ItemDoOrcamento;


public record FazerOrcamentoCommand(
    List<ItemDoOrcamento> itens,
    Integer cliente_id,
    Date validade,
    BigDecimal total,
    int desconto
) {

}
