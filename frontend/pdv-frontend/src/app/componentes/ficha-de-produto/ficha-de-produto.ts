import { Component } from '@angular/core';
import { Produto } from '../mostruario/mostruario';
import { ListaDeProdutos } from '../lista-de-produtos/lista-de-produtos';

@Component({
  selector: 'app-ficha-de-produto',
  imports: [ ListaDeProdutos],
  templateUrl: './ficha-de-produto.html',
  styleUrl: './ficha-de-produto.css'
})
export class FichaDeProduto {

  produto: Produto = {
    id: 1,
    preco: 4500,
    nome: "Notebook Dell Inspiron",
    categoria: 1,
    marca: "Dell",
    modelo: "Inspiron 15 3000",
    quantidade: 15,
    imageUrl: "https://picsum.photos/200?random=1",
    dimensoes: { altura: 2, largura: 35, peso: 1.8 }
  }
}
