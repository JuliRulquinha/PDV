import { Component, Input } from '@angular/core';
import { Produto } from '../pos/pos.component';
import { CommonModule } from '@angular/common';
import { OpcoesVenda } from '../opcoes-venda/opcoes-venda';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [CommonModule, OpcoesVenda],
  templateUrl: './lista-produtos.html',
  styleUrls: ['./lista-produtos.css']
})
export class ListaProdutos {

  @Input() product?: Produto;  // <-- This is required
  products: Produto[] = [];

  // Optional: automatically push new product into products array
  set addProduct(prod: Produto | undefined) {
    if (prod) this.products.push({ ...prod });
  }

   trackById(index: number, item: Produto) {
    return item.id;
  }
}
