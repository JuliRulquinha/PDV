import { Component, EventEmitter, inject, Output } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { Produto } from '../pos/pos.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pesquisa-de-produtos',
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './pesquisa-de-produtos.html',
  styleUrls: ['./pesquisa-de-produtos.css'] // Corrigi: era styleUrl
})
export class PesquisaDeProdutos {

  @Output() produtoAdicionado = new EventEmitter<Produto>();

  quantidadeProduto: number = 1;
  lastProduct?: Produto;
  searchTerm: string = '';
  codigoProduto: string = '';

  productService = inject(ProductService);

  products: Produto[] = [];

  adicionarProduto() {
    const code = Number(this.codigoProduto);
    const qtd = Number(this.quantidadeProduto);

    if (!code || !qtd || qtd < 1) {
      alert('Digite um código e quantidade válidos!');
      return;
    }

    this.productService.getProductById(code).subscribe({
      next: (data: Produto) => {
        const produtoComQtd = { ...data, quantidade: qtd };
        this.products.push(produtoComQtd);
        this.codigoProduto = '';
        this.quantidadeProduto = 1;

        // Emitindo para o componente pai
        this.produtoAdicionado.emit(produtoComQtd);
      },
      error: (err) => {
        console.error(err);
        alert('Produto não encontrado!');
      }
    });
  }
}
