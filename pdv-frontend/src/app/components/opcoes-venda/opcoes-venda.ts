import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Produto } from '../pos/pos.component';
import { selectAllProdutos } from '../../store/produto.selectors';
import { clearProdutos } from '../../store/produto.actions'; // vamos criar essa ação
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-opcoes-venda',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './opcoes-venda.html',
  styleUrls: ['./opcoes-venda.css']
})
export class OpcoesVenda {
  valorRecebido: number = 0;
  produtos$: Observable<Produto[]>;

  constructor(private store: Store) {
    this.produtos$ = this.store.select(selectAllProdutos);
  }

  getTotal(products: Produto[]): number {
    return products.reduce((sum, p) => sum + (p.valorVenda ?? 0) * p.quantidade, 0);
  }

  getTroco(products: Produto[]): number {
    const total = this.getTotal(products);
    return this.valorRecebido > total ? this.valorRecebido - total : 0;
  }

  finalizarVenda() {
    alert('Venda finalizada!');
    this.store.dispatch(clearProdutos());
    this.valorRecebido = 0;
  }

  cancelar() {
    alert('Venda cancelada!');
    this.store.dispatch(clearProdutos());
    this.valorRecebido = 0;
  }
}
