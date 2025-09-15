import { Component, inject, OnInit } from '@angular/core';
import { ProductService } from '../../services/product-service';

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
  templateUrl: './pos.component.html',
  styleUrls: ['./pos.component.css']
})
export class PosComponent implements OnInit{
  ngOnInit(){
    this.productService.getProductById(1).subscribe( data => {
      
      this.products.push(data);
    })
  }

  productService = inject(ProductService)

  

  products: Produto[] = [
    { id: 2, nome: 'Arroz', valorVenda: 20.00, quantidade: 2 },
    { id: 3, nome: 'Feijão', valorVenda: 20.00, quantidade: 2 },
  ];

  get total() {
    return this.products.reduce((sum, p) => sum + p.valorVenda * p.quantidade, 0);
  }

  finalizarVenda() {
    alert('Venda finalizada!');
  }

  cancelar() {
    alert('Venda cancelada!');
  }
}
