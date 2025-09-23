import { Component } from '@angular/core';
import { Produto } from '../pos/pos.component';

@Component({
  selector: 'app-opcoes-venda',
  imports: [],
  templateUrl: './opcoes-venda.html',
  styleUrl: './opcoes-venda.css'
})
export class OpcoesVenda {
  tipoPagamento: string = 'dinheiro';
  valorRecebido: number = 0;

    finalizarVenda(products: Produto[]) {
    alert('Venda finalizada!');
    products = [];
  }

  cancelar(products: Produto[]) {
    alert('Venda cancelada!');
    products = [];
  }

  getTotal(products: Produto[]) {
    return products.reduce((sum, p) => sum + (p.valorVenda ?? 0) * p.quantidade, 0);
  }
}
