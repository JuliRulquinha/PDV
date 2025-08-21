package com.crossmade.pdv.infraestrutura.orcamento;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.orcamento.Orcamento;

public interface SpringDataOrcamentoRepositorio extends JpaRepository<Orcamento, Integer>{

}
