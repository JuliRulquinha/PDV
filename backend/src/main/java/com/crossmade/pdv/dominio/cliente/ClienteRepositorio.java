package com.crossmade.pdv.dominio.cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositorio {
    Cliente salvar(Cliente cliente);
    Optional<Cliente> buscarPorId(Integer id);
    List<Cliente> listarTodas();
    void deletar(Integer id);
}
