import { createReducer, on } from '@ngrx/store';
import { addProduto, clearProdutos } from './produto.actions';
import { Produto } from '../components/pos/pos.component';

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
