import { createFeatureSelector, createSelector } from '@ngrx/store';
import { ProdutoState } from './produto.reducer';

export const selectProdutoState = createFeatureSelector<ProdutoState>('produtos');

export const selectAllProdutos = createSelector(
  selectProdutoState,
  (state: ProdutoState) => state.produtos
);

export const selectLastProduto = createSelector(
  selectProdutoState,
  (state: ProdutoState) => state.produtos[state.produtos.length - 1]
);
