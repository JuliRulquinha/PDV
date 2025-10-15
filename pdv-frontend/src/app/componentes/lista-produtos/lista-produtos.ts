import { Component, HostListener } from '@angular/core';
import { Produto } from '../pos/pos.component';
import { CommonModule } from '@angular/common';
import { OpcoesVenda } from '../opcoes-venda/opcoes-venda';
import { props, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { selectAllProdutos, selectLastProduto } from '../../store/produto.selectors';
import { removerProdutoDaLista } from '../../store/produto.actions';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [CommonModule, OpcoesVenda],
  templateUrl: './lista-produtos.html',
  styleUrls: ['./lista-produtos.css']
})
export class ListaProdutos {

  produtos$: Observable<Produto[]>;       // lista acumulativa
  lastProduct$: Observable<Produto | undefined>;
  produtoSelecionado!: Produto | null; 

  constructor(private store: Store) {
    this.produtos$ = this.store.select(selectAllProdutos);
    this.lastProduct$ = this.store.select(selectLastProduto);
  }

  trackById(index: number, item: Produto) {
    return item.id ?? index;
  }

  deletarProdutoDaLista(nome: string | undefined){
    this.store.dispatch(removerProdutoDaLista({nome}));
  }

  selecionarProduto(produto: Produto){
    console.log(produto);
    this.produtoSelecionado = produto;
  }

  @HostListener('window:keydown', ['$event'])
  onKeyDown(event: KeyboardEvent) {
  

  if (event.key === 'Delete') {
    if(confirm("Tem certeza que deseja excluir o produto "+ this.produtoSelecionado?.nome)){
      this.deletarProdutoDaLista(this.produtoSelecionado?.nome);
      this.produtoSelecionado = null;
    }
    
  }

 }
}
