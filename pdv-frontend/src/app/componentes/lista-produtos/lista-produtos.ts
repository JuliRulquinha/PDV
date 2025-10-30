import { Component, EventEmitter, HostListener, inject, Output } from '@angular/core';
import { Produto } from '../pos/pos.component';
import { CommonModule } from '@angular/common';
import { OpcoesVenda } from '../opcoes-venda/opcoes-venda';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { selectAllProdutos, selectLastProduto } from '../../store/produto.selectors';
import { removerProdutoDaLista } from '../../store/produto.actions';
import { ServicoOrcamento } from '../../servicos/entities/servico-orcamento';
import { ServicoPedido } from '../../servicos/entities/servico-pedido';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [CommonModule, OpcoesVenda],
  templateUrl: './lista-produtos.html',
  styleUrls: ['./lista-produtos.css']
})
export class ListaProdutos {

  @Output() finalizarVendaEvento = new EventEmitter();
  produtos$: Observable<Produto[]>;
  lastProduct$: Observable<Produto | undefined>;
  produtoSelecionado!: Produto | null; 

  servicoOrcamento = inject(ServicoOrcamento);
  servicoPedido = inject(ServicoPedido);

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
    this.produtoSelecionado = produto;
  }

  @HostListener('window:keydown', ['$event'])
  onKeyDown(event: KeyboardEvent) {
    if (event.key === 'Delete') {
      if(confirm("Tem certeza que deseja excluir o produto " + this.produtoSelecionado?.nome)){
      this.deletarProdutoDaLista(this.produtoSelecionado?.nome);
      this.produtoSelecionado = null;
      }
    }
  }

  mostrarModalDoCliente(){
    this.finalizarVendaEvento.emit();
  }
}
