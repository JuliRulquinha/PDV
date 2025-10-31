package com.crossmade.pdv.infraestrutura.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.pedido.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataPedidoRepositorio extends JpaRepository<Pedido, Integer>{
    @Query(
            value = """
            SELECT *\s
                                     FROM pedidos p
                                     ORDER BY p.id
                                     OFFSET (10 * :pagina)
                                     LIMIT 10;
        """,
            nativeQuery = true
    )
    public List<Pedido> paginar(@Param(value = "pagina") int pagina);

    @Query(
            value = """
            SELECT count(*) FROM pedidos p
        """,
            nativeQuery = true
    )
    public int getCount();
}
