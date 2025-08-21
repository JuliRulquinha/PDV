package com.crossmade.pdv.infraestrutura.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crossmade.pdv.dominio.produto.Produto;

public interface SpringDataProdutoRepositorio extends JpaRepository<Produto, Integer>{
  @Query(   
        value = """
            SELECT * FROM produtos p
            JOIN category c ON c.id = p.categoria_id
            WHERE c.nome = :nomeDaCategoria
        """,
        nativeQuery = true
   )
    public List<Produto> findByCategoriaNome(@Param(value = "nomeDaCategoria") String nomeDaCategoria);


    @Query(
        value = """
            SELECT * FROM produtos p
            WHERE p.nome = :nome
        """,
        nativeQuery = true
    )
    public List<Produto> findByNome(@Param(value = "nome") String nome);
}
