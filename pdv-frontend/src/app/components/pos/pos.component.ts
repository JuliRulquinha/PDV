import { Component, inject, OnInit } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

export interface Produto {
  id?: number;
  nome?: string;
  fornecedor?: Fornecedor;
  categoria?: Categoria;
  marca?: string;
  modelo?: string;
  quantidade: number;
  valorCusto?: number; // <-- make optional
  valorVenda?: number; // <-- make optional
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
    CommonModule,
    FormsModule
  ],
  templateUrl: './pos.component.html',
  styleUrls: ['./pos.component.css']
})
export class PosComponent implements OnInit{
  tipoPagamento: string = 'dinheiro';
  valorRecebido: number = 0;
  quantidadeProduto: number = 1;
  lastProduct?: Produto;
  searchTerm: string = '';

  trackById(index: number, item: Produto) {
    return item.id;
  }

  ngOnInit() {
    // Optionally, load initial products or setup
    this.updateLastProduct();
  }

  updateLastProduct() {
    this.lastProduct = this.products.length ? this.products[this.products.length - 1] : undefined;
  }

  productService = inject(ProductService);

  codigoProduto: string = '';

  products: Produto[] = [
  ];

  adicionarProduto() {
    debugger;
    const code = Number(this.codigoProduto);
    const qtd = Number(this.quantidadeProduto);
    if (!code || !qtd || qtd < 1) {
      alert('Digite um código e quantidade válidos!');
      return;
    }
    this.productService.getProductById(code).subscribe({
      next: (data: Produto) => {
        this.products.push({ ...data, quantidade: qtd });
        this.codigoProduto = '';
        this.quantidadeProduto = 1;
        this.updateLastProduct();
      },
      error: (err) => {
        console.error(err);
        alert('Produto não encontrado!');
      }
    });
  }

  get total() {
    return this.products.reduce((sum, p) => sum + (p.valorVenda ?? 0) * p.quantidade, 0);
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
