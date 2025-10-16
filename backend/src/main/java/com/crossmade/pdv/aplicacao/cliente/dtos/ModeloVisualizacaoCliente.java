package com.crossmade.pdv.aplicacao.cliente.dtos;

import java.util.List;

import com.crossmade.pdv.dominio.endereco.Endereco;

public record ModeloVisualizacaoCliente(
    String nome,
    String telefone,
    String email,
    List<Endereco> enderecos
) {}
