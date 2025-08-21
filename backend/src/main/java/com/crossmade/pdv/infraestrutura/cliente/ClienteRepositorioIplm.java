package com.crossmade.pdv.infraestrutura.cliente;

import java.util.List;
import java.util.Optional;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Cliente> listarTodas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodas'");
    }

    @Override
    public void deletar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

}
