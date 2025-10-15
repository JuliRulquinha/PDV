import { createReducer, on } from '@ngrx/store';

import { Produto } from '../componentes/pos/pos.component';
import { clearProdutos, addProduto, removerProdutoDaLista } from './produto.actions';


export interface ProdutoState {
  produtos: Produto[];
}

export const initialState: ProdutoState = {
  produtos: []
};

export const produtoReducer = createReducer(
  initialState,
  on(addProduto, (state, { produto }) => ({
    ...state,
    produtos: [...state.produtos, produto]
  })),

  on(clearProdutos, state => ({
    ...state,
    produtos: []
  })),
  
  on(removerProdutoDaLista, (state, { nome}) => ({
    ...state,
    produtos: state.produtos.filter(p => p.nome !== nome)
  }))
);
