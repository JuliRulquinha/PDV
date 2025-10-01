import { Component, EventEmitter, inject, Output } from '@angular/core';
import { Produto } from '../pos/pos.component';
import { ServicoProduto } from '../../services/servico-produto';
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
   productService = inject(ServicoProduto);
   produto? : Produto;

  pesquisarProduto() {
    const code = Number(this.codigoProduto);


    if (!code) {
      alert('Digite um código e quantidade válidos!');
      return;
    }

    this.productService.buscarProdutoPorId(code).subscribe({
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

  @Output() fechar = new EventEmitter<void>();

  fecharConsulta() {
    this.fechar.emit();
  }
}
