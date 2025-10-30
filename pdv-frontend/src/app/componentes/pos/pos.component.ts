import { Component, HostListener, inject, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PesquisaDeProdutos } from '../pesquisa-de-produtos/pesquisa-de-produtos';
import { CheckoutDisplay } from '../checkout-display/checkout-display';
import { ListaProdutos } from '../lista-produtos/lista-produtos';
import { ConsultaPreco } from '../consulta-preco/consulta-preco';
import { Clientes } from '../clientes/clientes';
import { ServicoPedido } from '../../servicos/entities/servico-pedido';

export interface Produto {
  id?: number;
  nome?: string;
  fornecedor?: Fornecedor;
  categoria?: Categoria;
  marca?: string;
  modelo?: string;
  quantidade: number;
  valorCusto?: number; 
  valorVenda?: number; 
  imageUrl?: string;
  validade?: Date;
  dimensoes?: Dimensoes;
}


export interface Fornecedor {
  id: number;
  nome: string;
  telefone: string;
  email: string;
}

export interface Categoria {
  id: number;
  nome: string;
  descricao: string;
}

export interface Dimensoes {
  peso: number;
  altura: number;
  largura: number;
  
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
    ConsultaPreco,
    Clientes
  ],
  templateUrl: './pos.component.html',
  styleUrls: ['./pos.component.css'],
  
})
export class PosComponent implements OnInit{
  @Input() lastProduct?: Produto;
  @Input() products: Produto[] = [];

  servicoDePedido = inject(ServicoPedido);

  mostrarConsultaPreco = false;
  mostrarModalCliente = false;

  ngOnInit() {
    this.updateLastProduct();
  }

  trackById(index: number, item: Produto) {
    return item.id;
  }

  updateLastProduct() {
    this.lastProduct = this.products.length ? this.products[this.products.length - 1] : undefined;
  }

  onProdutoAdicionado(produto: Produto) {
    this.products.push(produto); 
    this.updateLastProduct();    
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

  mostrarModalDoCliente(){
    this.mostrarModalCliente = true;
  }

  pularInputCliente(){
    this.mostrarModalCliente = false;
  }


  @HostListener('window:keydown', ['$event'])
  onKeyDown(event: KeyboardEvent) {
  
    if (event.key === 'F2') {
      this.consultar();
    }

    if (event.key === 'Escape') {
      this.fecharConsulta();
    }
  }

  finalizarACompra(){
    if(confirm("Deseja finalizar a compra?")){
      this.servicoDePedido.fazerPedido().subscribe();
    }
  }
}

