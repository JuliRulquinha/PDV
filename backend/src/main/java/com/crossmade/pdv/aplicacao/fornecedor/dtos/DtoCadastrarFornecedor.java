package com.crossmade.pdv.aplicacao.fornecedor.dtos;

import com.crossmade.pdv.dominio.endereco.Endereco;
import com.crossmade.pdv.dominio.produto.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public record DtoCadastrarFornecedor(
         String nome,
         String telefone,
         String email,
         List<Endereco> enderecos
) {
}
