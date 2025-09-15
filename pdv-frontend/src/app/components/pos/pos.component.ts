import { Component, inject, OnInit } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { FormsModule } from '@angular/forms';

export interface Produto {
  id: number;
  nome: string;
  fornecedor?: Fornecedor;
  categoria?: Categoria;
  marca?: string;
  modelo?: string;
  quantidade: number;
  valorCusto?: number; // Use number for BigDecimal
  valorVenda: number; // Use number for BigDecimal
  imageUrl?: string;
  validade?: Date;
  dimensoes?: Dimensoes;
}

// Example interfaces for related types:
export interface Fornecedor {
  id: number;
  nome: string;
  // add other fields as needed
}

export interface Categoria {
  id: number;
  nome: string;
  // add other fields as needed
}

export interface Dimensoes {
  // define fields as needed, e.g.:
  largura: number;
  altura: number;
  profundidade: number;
}

@Component({
  selector: 'app-pos',
  standalone: true,
  imports: [
    FormsModule // <-- aqui
  ],
  templateUrl: './pos.component.html',
  styleUrls: ['./pos.component.css']
})
export class PosComponent implements OnInit{
  trackById(index: number, item: Produto) {
    return item.id;
  }
  ngOnInit() {
    // Optionally, load initial products or setup
  }

  productService = inject(ProductService);

  codigoProduto: string = '';

  products: Produto[] = [
    { id: 2, nome: 'Arroz', valorVenda: 20.00, quantidade: 2 },
    { id: 3, nome: 'Feijão', valorVenda: 20.00, quantidade: 2 },
  ];

  adicionarProduto() {
    debugger;
    const code = Number(this.codigoProduto);
    if (!code) {
      alert('Digite um código válido!');
      return;
    }
    this.productService.getProductById(code).subscribe({
    next: (data: Produto) => {
     
        this.products.push(data);
      
      this.codigoProduto = ''; // limpa o input
    },
    error: (err) => {
      console.error(err);
      alert('Produto não encontrado!');
    }
  });
  }

  get total() {
    return this.products.reduce((sum, p) => sum + p.valorVenda * p.quantidade, 0);
  }

  finalizarVenda() {
    alert('Venda finalizada!');
    this.products = [];
  }

  cancelar() {
    alert('Venda cancelada!');
    this.products = [];
  }
}
