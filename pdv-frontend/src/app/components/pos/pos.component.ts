import { Component, HostListener, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PesquisaDeProdutos } from '../pesquisa-de-produtos/pesquisa-de-produtos';
import { CheckoutDisplay } from '../checkout-display/checkout-display';
import { ListaProdutos } from '../lista-produtos/lista-produtos';
import { ConsultaPreco } from '../consulta-preco/consulta-preco';

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
    ListaProdutos, 
    ConsultaPreco
  ],
  templateUrl: './pos.component.html',
  styleUrls: ['./pos.component.css'],
  
})
export class PosComponent implements OnInit{
  @Input() lastProduct?: Produto;
  @Input() products: Produto[] = [];

    mostrarConsultaPreco = false;

  ngOnInit() {
    this.updateLastProduct();
  }

  trackById(index: number, item: Produto) {
    return item.id;
  }

  updateLastProduct() {
    this.lastProduct = this.products.length ? this.products[this.products.length - 1] : undefined;
  }

  // Método para receber do filho
  onProdutoAdicionado(produto: Produto) {
    this.products.push(produto); // adiciona à lista
    this.updateLastProduct();    // atualiza o lastProduct
  }

  searchProduct(id: number) {
  const found = this.products.find(p => p.id === id);
  if (found) {
    this.lastProduct = found;
  }
}

  consultar() {
    this.mostrarConsultaPreco = true;
  }

  fecharConsulta() {
    this.mostrarConsultaPreco = false;
  }

  @HostListener('window:keydown', ['$event'])
onKeyDown(event: KeyboardEvent) {
  console.log('Tecla pressionada:', event.key);

  if (event.key === 'F11') {
    this.consultar();
  }
}
}

