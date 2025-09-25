import { Component, inject } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { selectLastProduto } from '../../store/produto.selectors';
import { Produto } from '../pos/pos.component';
import { PesquisaDeProdutos } from '../pesquisa-de-produtos/pesquisa-de-produtos';
import { ProductService } from '../../services/product-service';
import { addProduto } from '../../store/produto.actions';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-consulta-preco',
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './consulta-preco.html',
  styleUrl: './consulta-preco.css'
})
export class ConsultaPreco {

   codigoProduto: string = '';
   productService = inject(ProductService);
   produto? : Produto;

  pesquisarProduto() {
    const code = Number(this.codigoProduto);


    if (!code) {
      alert('Digite um código e quantidade válidos!');
      return;
    }

    this.productService.getProductById(code).subscribe({
      next: (data: Produto) => {

        this.produto = data;
        this.codigoProduto = '';
        
      },
      error: (err) => {
        console.error(err);
        alert('Produto não encontrado!');
      }
    });
  }
}
