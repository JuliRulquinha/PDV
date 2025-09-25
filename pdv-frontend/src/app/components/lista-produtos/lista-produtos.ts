import { Component, Input } from '@angular/core';
import { Produto } from '../pos/pos.component';
import { CommonModule } from '@angular/common';
import { OpcoesVenda } from '../opcoes-venda/opcoes-venda';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { addProduto } from '../../store/produto.actions';
import { selectAllProdutos, selectLastProduto } from '../../store/produto.selectors';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [CommonModule, OpcoesVenda],
  templateUrl: './lista-produtos.html',
  styleUrls: ['./lista-produtos.css']
})
export class ListaProdutos {

 lastProduct$: Observable<Produto | undefined>;

  constructor(private store: Store) {
    this.lastProduct$ = this.store.select(selectLastProduto);
  }
}
