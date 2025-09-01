package com.crossmade.pdv.infraestrutura.mediator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.crossmade.pdv.aplicacao.produto.query.buscarTodos.BuscarTodosOsProdutosHandler;
import com.crossmade.pdv.aplicacao.produto.query.buscarTodos.BuscarTodosOsProdutosQuery;
import com.crossmade.pdv.aplicacao.produto.query.por_categoria.BuscarPorCategoriaHandler;
import com.crossmade.pdv.aplicacao.produto.query.por_categoria.BuscarPorCategoriaQuery;
import com.crossmade.pdv.aplicacao.produto.query.por_id.BuscarPorIdHandler;
import com.crossmade.pdv.aplicacao.produto.query.por_id.BuscarPorIdQuery;
import com.crossmade.pdv.aplicacao.produto.query.por_nome.BuscarPorNomeHandler;
import com.crossmade.pdv.aplicacao.produto.query.por_nome.BuscarPorNomeQuery;
import java.util.Map;

@Configuration
public class MediatorConfig {
    @Bean
    public Mediator mediator(
        BuscarPorIdHandler buscarPorIdHandler,
        BuscarTodosOsProdutosHandler buscarTodosOsProdutosHandler,
        BuscarPorNomeHandler buscarPorNomeHandler,
        BuscarPorCategoriaHandler buscarPorCategoriaHandler
    ) {
        return new SimpleMediator(Map.of(
            BuscarPorIdQuery.class, buscarPorIdHandler,
            BuscarTodosOsProdutosQuery.class, buscarTodosOsProdutosHandler,
            BuscarPorNomeQuery.class, buscarPorNomeHandler,
            BuscarPorCategoriaQuery.class, buscarPorCategoriaHandler
        ));
    }
}
