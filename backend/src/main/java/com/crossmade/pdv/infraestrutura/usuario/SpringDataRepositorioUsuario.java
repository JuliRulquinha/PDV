package com.crossmade.pdv.infraestrutura.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.usuario.Usuario;

public interface SpringDataRepositorioUsuario extends JpaRepository<Usuario, Integer> {

}
