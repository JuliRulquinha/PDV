package com.crossmade.pdv.infraestrutura.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crossmade.pdv.dominio.produto.Produto;

public interface SpringDataProdutoRepositorio extends JpaRepository<Produto, Integer>{
  @Query(   
        value = """
            SELECT p.id, p.nome, p.fornecedor_id, p.categoria_id, p.marca, p.modelo,
            p.quantidade, p.valor_custo, p.valor_venda, p.image_url, p.validade,
            p.peso, p.altura, p.largura
            FROM produtos p
            JOIN categorias c ON c.id = p.categoria_id
            WHERE c.nome = :nomeDaCategoria
        """,
        nativeQuery = true
   )
    public List<Produto> findByCategoriaNome(@Param(value = "nomeDaCategoria") String nomeDaCategoria);


    public List<Produto> findByNomeContaining(String nome);
}
