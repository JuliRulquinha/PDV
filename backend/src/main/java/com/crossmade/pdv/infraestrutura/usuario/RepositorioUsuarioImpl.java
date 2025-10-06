package com.crossmade.pdv.infraestrutura.usuario;

import com.crossmade.pdv.dominio.usuario.Usuario;
import com.crossmade.pdv.dominio.usuario.UsuarioRepositorio;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioImpl implements UsuarioRepositorio {

    private final SpringDataRepositorioUsuario repositorio;

    public RepositorioUsuarioImpl(SpringDataRepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @Override
    public void deletar(Integer id) {
       repositorio.deleteById(id);
    }

}


