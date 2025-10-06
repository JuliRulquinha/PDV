package com.crossmade.pdv.dominio.usuario;

import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;

public interface UsuarioRepositorio {
    Usuario salvar(Usuario usuario);
    Usuario buscarPorId(Integer id);
    void deletar(Integer id);
}
