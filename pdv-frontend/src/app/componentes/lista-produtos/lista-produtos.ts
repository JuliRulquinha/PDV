import { Component } from '@angular/core';
import { Produto } from '../pos/pos.component';
import { CommonModule } from '@angular/common';
import { OpcoesVenda } from '../opcoes-venda/opcoes-venda';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { selectAllProdutos, selectLastProduto } from '../../store/produto.selectors';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [CommonModule, OpcoesVenda],
  templateUrl: './lista-produtos.html',
  styleUrls: ['./lista-produtos.css']
})
export class ListaProdutos {

  produtos$: Observable<Produto[]>;       // lista acumulativa
  lastProduct$: Observable<Produto | undefined>; // último produto adicionado

  constructor(private store: Store) {
    this.produtos$ = this.store.select(selectAllProdutos);
    this.lastProduct$ = this.store.select(selectLastProduto);
  }

  trackById(index: number, item: Produto) {
    return item.id ?? index;
  }
}
