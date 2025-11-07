package com.crossmade.pdv.dominio.cliente;

import java.util.List;


public interface ClienteRepositorio {
    Cliente salvar(Cliente cliente);
    Cliente buscarPorId(Integer id);
    Cliente buscarPorNome(String nome);
    List<Cliente> listarTodos();
    List<Cliente> listarTodos(String nome);
    void deletar(Integer id);
}
