import { Component, EventEmitter, inject, Output } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Produto } from '../pos/pos.component';
import { selectAllProdutos } from '../../store/produto.selectors';
import { clearProdutos } from '../../store/produto.actions'; // vamos criar essa ação
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

  @Output() finalizarVendaEvento = new EventEmitter();
  @Output() criarOrcamentoEvento = new EventEmitter();

  produtos$: Observable<Produto[]>;
  tipoPagamento: string = 'dinheiro';
  valorRecebido: number = 0;
  quantidadeDeItens: number = 0;

  servicoOrcamento = inject(ServicoOrcamento);
  servicoPedido = inject(ServicoPedido);

  constructor(private store: Store) {
    this.produtos$ = this.store.select(selectAllProdutos);
  }

  finalizarVenda() {
    this.finalizarVendaEvento.emit();
  }

  salvarOrcamento(){
    this.criarOrcamentoEvento.emit();
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
