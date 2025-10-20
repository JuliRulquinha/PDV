package com.crossmade.pdv.dominio.usuario;



public interface UsuarioRepositorio {
    Usuario salvar(Usuario usuario);
    Usuario buscarPorId(Integer id);
    Usuario buscarPorNome(String nome);
    void deletar(Integer id);
}
