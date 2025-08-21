package com.crossmade.pdv.infraestrutura.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossmade.pdv.dominio.categoria.Categoria;

public interface SpringDataCategoriaRepositorio extends JpaRepository<Categoria, Integer>{

}
