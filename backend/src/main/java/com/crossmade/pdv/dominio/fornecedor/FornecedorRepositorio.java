package com.crossmade.pdv.dominio.fornecedor;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoCadastrarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ListaFornecedoresDto;

import java.util.List;


public interface FornecedorRepositorio {
    Fornecedor salvar(Fornecedor fornecedor);
    Fornecedor buscarPorId(Integer id);
    List<Fornecedor> listarTodos();
    void deletar(Integer id);
}
