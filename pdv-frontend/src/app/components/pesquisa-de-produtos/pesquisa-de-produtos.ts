import { Component, inject } from '@angular/core';
import { ServicoProduto } from '../../services/servico-produto';
import { Produto } from '../pos/pos.component';
import { Store } from '@ngrx/store';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { addProduto } from '../../store/produto.actions';
import { selectLastProduto } from '../../store/produto.selectors';
import { Observable } from 'rxjs';

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

  lastProduct$: Observable<Produto | undefined>;

  productService = inject(ServicoProduto);
  store = inject(Store);

  constructor() {
    this.lastProduct$ = this.store.select(selectLastProduto);
  }

  adicionarProduto() {
    const code = Number(this.codigoProduto);
    const qtd = Number(this.quantidadeProduto);

    if (!code || !qtd || qtd < 1) {
      alert('Digite um código e quantidade válidos!');
      return;
    }

    this.productService.buscarProdutoPorId(code).subscribe({
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
