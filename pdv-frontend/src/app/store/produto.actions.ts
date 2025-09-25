import { createAction, props } from '@ngrx/store';
import { Produto } from '../components/pos/pos.component';

export const addProduto = createAction(
  '[Produto] Add Produto',
  props<{ produto: Produto }>()
);

export const clearProdutos = createAction('[Produto] Clear Produtos');
