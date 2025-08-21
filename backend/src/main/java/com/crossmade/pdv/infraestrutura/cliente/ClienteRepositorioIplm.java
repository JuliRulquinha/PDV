package com.crossmade.pdv.infraestrutura.cliente;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crossmade.pdv.dominio.cliente.Cliente;
import com.crossmade.pdv.dominio.cliente.ClienteRepositorio;


@Repository
public class ClienteRepositorioIplm implements ClienteRepositorio{

    private final SpringDataClienteRepositorio repositorio;

    public ClienteRepositorioIplm(SpringDataClienteRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public Cliente buscarPorId(Integer id) {
       return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> listarTodos() {
        return repositorio.findAll();
    }

    @Override
    public void deletar(Integer id) {
        repositorio.deleteById(id);
    }

}
