package com.crossmade.pdv.dominio.fornecedor;

import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoCadastrarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.DtoVisualizarFornecedor;
import com.crossmade.pdv.aplicacao.fornecedor.dtos.ListaFornecedoresDto;

import java.util.List;


public interface FornecedorRepositorio {
    DtoVisualizarFornecedor salvar(DtoCadastrarFornecedor fornecedor);
    DtoVisualizarFornecedor buscarPorId(Integer id);
    ListaFornecedoresDto listarTodos();
    void deletar(Integer id);
}
