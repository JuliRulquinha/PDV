package com.crossmade.pdv.infraestrutura.orcamento;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.crossmade.pdv.dominio.orcamento.Orcamento;
import com.crossmade.pdv.dominio.orcamento.OrcamentoRepositorio;


@Repository
public class OrcamentoRepositorioIplm implements OrcamentoRepositorio{

     private final SpringDataOrcamentoRepositorio repositorio;

    public OrcamentoRepositorioIplm(SpringDataOrcamentoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public Orcamento salvar(Orcamento orcamento) {
        return repositorio.save(orcamento);
    }

    @Override
    public Optional<Orcamento> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public List<Orcamento> listarTodos() {
        return repositorio.findAll();
    }

    @Override
    public void cancelar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelar'");
    }

}
