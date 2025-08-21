package com.crossmade.pdv.infraestrutura.fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.fornecedor.Fornecedor;

public interface SpringDataFornecedorRepositorio extends JpaRepository<Fornecedor, Integer>{

}
