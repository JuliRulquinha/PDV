import { Component } from '@angular/core';
import { ProductListComponent } from '../product-list/product-list.component';

@Component({
  selector: 'app-pos-screen',
  imports: [ProductListComponent],
  templateUrl: './pos-screen.component.html',
  styleUrls: ['./pos-screen.component.css']
})
export class PosScreenComponent {
  // Exemplo de produtos
  products = [
    { code: '001', name: 'Arroz', price: 20.00, quantity: 2 },
    { code: '002', name: 'Feijão', price: 10.00, quantity: 1 }
  ];

  get total() {
    return this.products.reduce((sum, p) => sum + p.price * p.quantity, 0);
  }

  finalizarVenda() {
    alert('Venda finalizada!');
  }

  cancelar() {
    alert('Venda cancelada!');
  }
}
