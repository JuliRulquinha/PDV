package com.crossmade.pdv.infraestrutura.produto;

import java.util.ArrayList;
import java.util.List;

import com.crossmade.pdv.aplicacao.produto.dtos.DtoCadastroProduto;
import com.crossmade.pdv.aplicacao.produto.dtos.DtoVisualizarProduto;
import com.crossmade.pdv.aplicacao.produto.mapper.MapperProduto;
import org.springframework.stereotype.Repository;

import com.crossmade.pdv.dominio.produto.Produto;
import com.crossmade.pdv.dominio.produto.ProdutoRepositorio;

@Repository
public class ProdutoRepositorioIplm implements ProdutoRepositorio{

     private final SpringDataProdutoRepositorio repositorio;
     private final MapperProduto mapper;

    public ProdutoRepositorioIplm(SpringDataProdutoRepositorio repositorio, MapperProduto mapper){
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public DtoVisualizarProduto salvar(DtoCadastroProduto dto) {

        Produto salvo = repositorio.save(mapper.dtoDeCadastroParaProduto(dto));
        return mapper.paraDtoDeVisualizar(salvo);
    }

    @Override
    public DtoVisualizarProduto buscarPorId(Integer id) {
        Produto salvo = repositorio.findById(id).orElse(null);
        return mapper.paraDtoDeVisualizar(salvo);
    }

    @Override
    public List<DtoVisualizarProduto> listarTodos(int pagina) {
        List<DtoVisualizarProduto> dtos =  new ArrayList<>();
        var produtosDoDb = repositorio.paginate(pagina);
        for (var produto: produtosDoDb){
            dtos.add(mapper.paraDtoDeVisualizar(produto));
        }
        return dtos;

    }

    @Override
    public void deletar(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<DtoVisualizarProduto> buscarPorNome(String nome) {
        List<DtoVisualizarProduto> dtos =  new ArrayList<>();
        var produtosDoDb = repositorio.findByNomeContaining(nome);
        for (var produto: produtosDoDb){
            dtos.add(mapper.paraDtoDeVisualizar(produto));
        }
        return dtos;
    }

    @Override
    public List<DtoVisualizarProduto> buscarPorCategoria(String categoria) {
        List<DtoVisualizarProduto> dtos =  new ArrayList<>();
        var produtosDoDb = repositorio.findByCategoriaNome(categoria);
        for (var produto: produtosDoDb){
            dtos.add(mapper.paraDtoDeVisualizar(produto));
        }
        return dtos;
    }

    @Override
    public List<DtoVisualizarProduto> buscarTodos() {
        List<DtoVisualizarProduto> dtos =  new ArrayList<>();
        var produtosDoDb = repositorio.findAll();
        for (var produto: produtosDoDb){
            dtos.add(mapper.paraDtoDeVisualizar(produto));
        }
        return dtos;
    }

    @Override
    public Produto atualizar(Integer id,  Produto produto) {
        var existente = repositorio.findById(id);
        if(existente.isEmpty()){
            return null;
        }
        produto.setId(id);
        return repositorio.save(produto);
    }

    @Override
    public int retornarContagem() {
        return repositorio.getCount();
    }
}
