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
  produtos$: Observable<Produto[]>;
  tipoPagamento: string = 'dinheiro';
  valorRecebido: number = 0;

  constructor(private store: Store) {
    // aqui você pega todos os produtos do NgRx
    this.produtos$ = this.store.select(selectAllProdutos);
  }

 finalizarVenda() {
  this.store.dispatch(clearProdutos()); // limpa imediatamente
  this.valorRecebido = 0;
  // Agora sim alerta
  setTimeout(() => alert('Venda finalizada!'), 0); 
}

cancelar() {
  this.store.dispatch(clearProdutos());
  this.valorRecebido = 0;
  setTimeout(() => alert('Venda cancelada!'), 0);
}

  getTotal(produtos: Produto[] = []) {
    return produtos.reduce((sum, p) => sum + (p.valorVenda ?? 0) * (p.quantidade ?? 1), 0);
  }

  getTroco(produtos: Produto[] = []) {
    const total = this.getTotal(produtos);
    return this.valorRecebido > total ? this.valorRecebido - total : 0;
  }
}
