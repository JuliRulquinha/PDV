package com.crossmade.pdv.infraestrutura.fornecedor;

import java.util.ArrayList;
import java.util.List;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoCadastrarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ListaFornecedoresDto;
import com.crossmade.pdv.aplicacao.fornecedor.mapper.MapperFornecedor;
import org.springframework.stereotype.Repository;

import com.crossmade.pdv.dominio.fornecedor.Fornecedor;
import com.crossmade.pdv.dominio.fornecedor.FornecedorRepositorio;


@Repository
public class FornecedorRepositorioIplm implements FornecedorRepositorio{

     private final SpringDataFornecedorRepositorio repositorio;
     private final MapperFornecedor mapper;

    public FornecedorRepositorioIplm(SpringDataFornecedorRepositorio repositorio, MapperFornecedor mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public DtoVisualizarFornecedor salvar(DtoCadastrarFornecedor dto) {
        var fornecedor = mapper.dtoDeCadastroParaProduto(dto);
        var salvo = repositorio.save(fornecedor);
        return mapper.paraDtoDeVisualizar(salvo);
    }

    @Override
    public DtoVisualizarFornecedor buscarPorId(Integer id) {
        var forncedorDoDb = repositorio.findById(id).orElse(null);
        return mapper.paraDtoDeVisualizar(forncedorDoDb);
    }

    @Override
    public ListaFornecedoresDto listarTodos() {
        var lista = repositorio.findAll();
        List<DtoVisualizarFornecedor> dtos = new ArrayList<>();

        for (var fornecedor: lista){
            dtos.add(mapper.paraDtoDeVisualizar(fornecedor));
        }

        return new ListaFornecedoresDto(dtos);
    }

    @Override
    public void deletar(Integer id) {
        repositorio.deleteById(id);
    }

}
