package com.crossmade.pdv.dominio.usuario;

import com.crossmade.pdv.aplicacao.usuario.dtos.DtoCadastrarUsuario;
import com.crossmade.pdv.aplicacao.usuario.dtos.DtoVisualizarUsuario;

public interface UsuarioRepositorio {
    DtoVisualizarUsuario salvar(DtoCadastrarUsuario usuario);
    DtoVisualizarUsuario buscarPorId(Integer id);
    void deletar(Integer id);
}
