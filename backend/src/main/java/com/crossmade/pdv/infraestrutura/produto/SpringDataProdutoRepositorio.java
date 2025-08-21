package com.crossmade.pdv.infraestrutura.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.produto.Produto;

public interface SpringDataProdutoRepositorio extends JpaRepository<Produto, Integer>{

}
