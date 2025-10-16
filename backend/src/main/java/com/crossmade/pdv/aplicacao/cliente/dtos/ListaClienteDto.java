package com.crossmade.pdv.aplicacao.cliente.dtos;

import java.util.List;

public record ListaClienteDto(
    List<DtoVisualizarCliente> clientes
) {}
