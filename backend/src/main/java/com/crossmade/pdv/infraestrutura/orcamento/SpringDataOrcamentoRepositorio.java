package com.crossmade.pdv.infraestrutura.orcamento;

import com.crossmade.pdv.dominio.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.orcamento.Orcamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataOrcamentoRepositorio extends JpaRepository<Orcamento, Integer>{

    @Query(
            value = """
            SELECT *\s
                                     FROM orcamentos o
                                     ORDER BY o.id
                                     OFFSET (10 * :pagina)
                                     LIMIT 10;
        """,
            nativeQuery = true
    )
    public List<Orcamento> paginate(@Param(value = "pagina") int pagina);

    @Query(
            value = """
            SELECT count(*) FROM orcamentos o
        """,
            nativeQuery = true
    )
    public int getCount();
}
