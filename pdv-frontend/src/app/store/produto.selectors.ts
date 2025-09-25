import { createFeatureSelector, createSelector } from '@ngrx/store';
import { ProdutoState } from './produto.reducer';

export const selectProdutoState = createFeatureSelector<ProdutoState>('produtos');

export const selectAllProdutos = createSelector(
  selectProdutoState,
  (state: ProdutoState) => state.produtos
);

export const selectLastProduto = createSelector(
   selectAllProdutos,
  (produtos) => produtos && produtos.length ? produtos[produtos.length - 1] : undefined
);
