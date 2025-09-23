import { Component, inject, Input, OnInit } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PesquisaDeProdutos } from '../pesquisa-de-produtos/pesquisa-de-produtos';
import { CheckoutDisplay } from '../checkout-display/checkout-display';
import { ListaProdutos } from '../lista-produtos/lista-produtos';
import { OpcoesVenda } from '../opcoes-venda/opcoes-venda';

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
  peso: number;
}

@Component({
  selector: 'app-pos',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    PesquisaDeProdutos,
    CheckoutDisplay,
    ListaProdutos
  ],
  templateUrl: './pos.component.html',
  styleUrls: ['./pos.component.css']
})
export class PosComponent implements OnInit{
  @Input() lastProduct?: Produto;
  @Input() products: Produto[] = [
  ];

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

  
}

