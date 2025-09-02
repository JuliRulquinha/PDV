import { Component } from '@angular/core';
import { Header } from '../header/header';
import { FichaDeProduto } from '../ficha-de-produto/ficha-de-produto';
import { ListaDeProdutos } from '../lista-de-produtos/lista-de-produtos';
import { FuncoesDoSistema } from '../funcoes-do-sistema/funcoes-do-sistema';
import { ResumoPagamento } from '../resumo-pagamento/resumo-pagamento';

@Component({
  selector: 'app-checkout',
  imports: [Header, FichaDeProduto, ListaDeProdutos, FuncoesDoSistema, ResumoPagamento],
  templateUrl: './checkout.html',
  styleUrl: './checkout.css'
})
export class Checkout {

}
