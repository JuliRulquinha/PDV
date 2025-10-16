package com.crossmade.pdv.aplicacao.orcamento.query.buscar;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.crossmade.pdv.aplicacao.cliente.mapper.MapperCliente;
import com.crossmade.pdv.aplicacao.orcamento.dtos.DtoVisualizarOrcamento;
import com.crossmade.pdv.aplicacao.orcamento.mapper.MapperOrcamento;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import com.crossmade.pdv.infraestrutura.orcamento.OrcamentoRepositorioIplm;

@Component
public class BuscarOrcamentoPorIdHandler {
    private final OrcamentoRepositorioIplm repositorio;
    private final MapperOrcamento mapper;
    private final MapperCliente mapperCliente;
    private final MapperProduto mapperProduto;

    public BuscarOrcamentoPorIdHandler(OrcamentoRepositorioIplm repositorio, MapperOrcamento mapper, MapperCliente mapperCliente, MapperProduto mapperProduto) {
        this.repositorio = repositorio;
        this.mapper = mapper;
        this.mapperCliente = mapperCliente;
        this.mapperProduto = mapperProduto;
    }

    public DtoVisualizarOrcamento handle(BuscarOrcamentoPorIdQuery query) {
        var orcamento = repositorio.buscarPorId(query.id());
        var clienteDto = mapperCliente.paraDtoDeVisualizar(orcamento.getCliente());
        var produtosDto = orcamento.getProdutos().stream().map(mapperProduto::paraDtoDeVisualizar).collect(Collectors.toList());
        return mapper.paraDtoDeVisualizar(orcamento, clienteDto, produtosDto);
    }
}
