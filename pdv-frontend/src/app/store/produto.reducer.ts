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
  on(addProduto, (state, { produto }) => {
    // If product with same id already exists, increment its quantidade
    // otherwise append the new product.
    const existingIndex = state.produtos.findIndex(p => p.id === produto.id);
    if (existingIndex !== -1) {
      const updated = state.produtos.map(p => {
        if (p.id === produto.id) {
          const existingQtd = typeof p.quantidade === 'number' ? p.quantidade : 0;
          const addedQtd = typeof produto.quantidade === 'number' ? produto.quantidade : 0;
          return { ...p, quantidade: existingQtd + addedQtd };
        }
        return p;
      });
      return { ...state, produtos: updated };
    }

    return { ...state, produtos: [...state.produtos, produto] };
  }),

  on(clearProdutos, state => ({
    ...state,
    produtos: []
  })),
  
  on(removerProdutoDaLista, (state, { nome}) => ({
    ...state,
    produtos: state.produtos.filter(p => p.nome !== nome)
  }))
);
