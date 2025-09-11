import { Component, Input } from '@angular/core';
import { Produto } from '../mostruario/mostruario';
import { ListaDeProdutos } from '../lista-de-produtos/lista-de-produtos';
import { BarraPesquisa } from '../barra-pesquisa/barra-pesquisa';

@Component({
  selector: 'app-ficha-de-produto',
  imports: [ ListaDeProdutos, BarraPesquisa],
  templateUrl: './ficha-de-produto.html',
  styleUrl: './ficha-de-produto.css'
})
export class FichaDeProduto {

  @Input() produto?: Produto;

   onMessageReceived(value: Produto) {
    this.produto = value;
  }
}
