import { Component, EventEmitter, HostListener, inject, OnInit, Output } from '@angular/core';
import { Produto } from '../pos/pos.component';
import { CommonModule } from '@angular/common';
import { OpcoesVenda } from '../opcoes-venda/opcoes-venda';
import { Store } from '@ngrx/store';
import { Observable, Subscription } from 'rxjs';
import { selectAllProdutos, selectLastProduto } from '../../store/produto.selectors';
import { clearProdutos, removerProdutoDaLista } from '../../store/produto.actions';
import { ServicoOrcamento } from '../../servicos/entities/servico-orcamento';
import { ServicoPedido } from '../../servicos/entities/servico-pedido';
import { ServicoCliente } from '../../servicos/entities/servico-cliente';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [CommonModule, OpcoesVenda],
  templateUrl: './lista-produtos.html',
  styleUrls: ['./lista-produtos.css']
})
export class ListaProdutos implements OnInit {

  @Output() abrirModalEvento = new EventEmitter();
  @Output() fazerPedidoEvento = new EventEmitter();
  @Output() fazerOrcamentoEvento = new EventEmitter();

  produtos$: Observable<Produto[]>;
  lastProduct$: Observable<Produto | undefined>;
  produtoSelecionado!: Produto | null; 
  subscriptionCliente? : Subscription;

  servicoOrcamento = inject(ServicoOrcamento);
  servicoPedido = inject(ServicoPedido);
  servicoCliente = inject(ServicoCliente);
  
  constructor(private store: Store) {
    this.produtos$ = this.store.select(selectAllProdutos);
    this.lastProduct$ = this.store.select(selectLastProduto);
  }
  ngOnInit(): void {
   //TODO: preciso fazer a lista se limpar apos a criação do orçamento ou pedido
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

  abrirModal(){
    this.abrirModalEvento.emit();
  }

  sinalizarCriacaoDePedido(){
    this.fazerPedidoEvento.emit();
  }

  sinalizarCriacaoDeOrcamento(){
    this.fazerOrcamentoEvento.emit();
  }
}
