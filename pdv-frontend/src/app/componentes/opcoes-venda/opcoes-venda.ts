import { Component, EventEmitter, inject, Output } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable, firstValueFrom } from 'rxjs';
import { Produto } from '../pos/pos.component';
import { selectAllProdutos } from '../../store/produto.selectors';
import { clearProdutos } from '../../store/produto.actions'; 
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { ServicoOrcamento } from '../../servicos/entities/servico-orcamento';
import { ServicoPedido } from '../../servicos/entities/servico-pedido';

@Component({
  selector: 'app-opcoes-venda',
  standalone: true,
  imports: [CommonModule, FormsModule, MatIconModule],
  templateUrl: './opcoes-venda.html',
  styleUrls: ['./opcoes-venda.css']
})
export class OpcoesVenda {

  @Output() abrirModalEvento = new EventEmitter();
  @Output() fazerPedidoEvento = new EventEmitter();
  @Output() fazerOrcamentoEvento = new EventEmitter();

  produtos$: Observable<Produto[]>;
  tipoPagamento: string = 'dinheiro';
  valorRecebido: number = 0;
  quantidadeDeItens: number = 0;

  servicoOrcamento = inject(ServicoOrcamento);
  servicoPedido = inject(ServicoPedido);

  constructor(private store: Store) {
    this.produtos$ = this.store.select(selectAllProdutos);
  }

  async finalizarVenda() {
    const produtos = await firstValueFrom(this.produtos$);
    if (this.totalDeItens(produtos) > 0) {
      this.abrirModalEvento.emit();
      this.fazerPedidoEvento.emit();
    } else {
      // feedback ao usuário
      setTimeout(() => alert('Adicione ao menos 1 item ao pedido.'), 0);
    }
  }

  async salvarOrcamento(){
    const produtos = await firstValueFrom(this.produtos$);
    if (this.totalDeItens(produtos) > 0) {
      this.abrirModalEvento.emit();
      this.fazerOrcamentoEvento.emit();
    } else {
      setTimeout(() => alert('Adicione ao menos 1 item ao orçamento.'), 0);
    }
  }

  cancelar() {
    this.store.dispatch(clearProdutos());
    this.valorRecebido = 0;
    setTimeout(() => alert('Venda cancelada!'), 0);
  }

  totalDeItens(produtos: Produto[] = []) {
    return produtos.reduce((sum, p) => sum + (p.quantidade ?? 0), 0);
  }

  getTotal(produtos: Produto[] = []) {
    return produtos.reduce((sum, p) => sum + (p.valorVenda ?? 0) * (p.quantidade ?? 1), 0);
  }

  getTroco(produtos: Produto[] = []) {
    const total = this.getTotal(produtos);
    return this.valorRecebido > total ? this.valorRecebido - total : 0;
  }
}
