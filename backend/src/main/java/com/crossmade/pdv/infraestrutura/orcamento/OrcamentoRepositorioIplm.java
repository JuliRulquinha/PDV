package com.crossmade.pdv.infraestrutura.orcamento;

import java.util.List;

import com.crossmade.pdv.dominio.orcamento.StatusOrcamento;
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
    public Orcamento buscarPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<Orcamento> listarTodos(int pagina) {
        return repositorio.paginate(pagina);
    }

    @Override
    public Orcamento cancelar(Integer id) {
        var orcamentoDoDb = repositorio.findById(id).orElse(null);
        orcamentoDoDb.setStatus(StatusOrcamento.CANCELADO);
        return repositorio.save(orcamentoDoDb);
    }

    @Override
    public Orcamento mudarStatus(Integer id, StatusOrcamento status) {
        var orcamentoDoDb = repositorio.findById(id).orElse(null);
        orcamentoDoDb.setStatus(status);
        return repositorio.save(orcamentoDoDb);
    }

    @Override
    public int retornarContagem() {
        return repositorio.getCount();
    }
}
