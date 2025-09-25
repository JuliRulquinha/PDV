import { createReducer, on } from '@ngrx/store';

import { Produto } from '../components/pos/pos.component';
import { clearProdutos, addProduto } from './produto.actions';





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
  }))
);
