import { Component, inject } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { Produto } from '../pos/pos.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pesquisa-de-produtos',
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './pesquisa-de-produtos.html',
  styleUrl: './pesquisa-de-produtos.css'
})
export class PesquisaDeProdutos {

  quantidadeProduto: number = 1;
  lastProduct?: Produto;
  searchTerm: string = '';

  productService = inject(ProductService);

  codigoProduto: string = '';

  products: Produto[] = [
  ];

  adicionarProduto() {
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
        //this.updateLastProduct();
      },
      error: (err) => {
        console.error(err);
        alert('Produto não encontrado!');
      }
    });
}}
