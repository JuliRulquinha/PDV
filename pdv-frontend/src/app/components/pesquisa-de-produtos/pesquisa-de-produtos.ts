import { Component, inject } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { Produto } from '../pos/pos.component';
import { Store } from '@ngrx/store';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { addProduto } from '../../store/produto.actions';

@Component({
  selector: 'app-pesquisa-de-produtos',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './pesquisa-de-produtos.html',
  styleUrls: ['./pesquisa-de-produtos.css']
})
export class PesquisaDeProdutos {
  quantidadeProduto: number = 1;
  codigoProduto: string = '';

  productService = inject(ProductService);
  store = inject(Store);

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
        this.store.dispatch(addProduto({ produto: produtoComQtd }));
        this.codigoProduto = '';
        this.quantidadeProduto = 1;
      },
      error: (err) => {
        console.error(err);
        alert('Produto não encontrado!');
      }
    });
  }
}
