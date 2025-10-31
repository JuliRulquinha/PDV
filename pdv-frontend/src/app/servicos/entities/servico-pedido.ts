import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Produto } from '../../componentes/pos/pos.component';
import { Store } from '@ngrx/store';
import { selectAllProdutos } from '../../store/produto.selectors';
import { filter, map, Observable, tap, take, switchMap } from 'rxjs';
import { Cliente } from './servico-cliente';

export interface ListaPedidos{
  contagem: number,
  pedidos: Pedido[]
}

export interface Pedido{
  id?: number,
  itens: ItemDoPedido[],
  cliente?: Cliente,
  validade: Date,
  total: number,
  desconto?: number,
  status: StatusDoPedido
}

export interface ItemDoPedido{
  id?: number,
  pedido_id?: number,
  produto_id: number,
  quantidade: number,
  valorUnitario: number | undefined,
  total: number
}

export enum StatusDoPedido{
  CRIADO,
  CONFIRMADO,
  PAGAMENTO_PENDENTE,
  PAGAMENTO_RECEBIDO,
  PAGAMENTO_RECUSADO,
  CANCELADO
}

@Injectable({
  providedIn: 'root'
})
export class ServicoPedido {
  baseUrl = "http://localhost:8080/api/pedidos";
  http = inject(HttpClient);
  store = inject(Store);

  mapearProdutoParaItem(produto: Produto): ItemDoPedido{
    return {
      produto_id: produto.id!,
      quantidade: produto.quantidade!,
      valorUnitario: produto.valorVenda!,
      total: produto.valorVenda! * produto.quantidade!,
    }
  }

  criarPedido(): Observable<Pedido> {
    // Map the current store products into a Pedido payload and emit once
    return this.store.select(selectAllProdutos).pipe(
      filter(produtos => produtos.length > 0),
      map(produtos => produtos.map(p => this.mapearProdutoParaItem(p))),
      take(1),
      map((itens: ItemDoPedido[]) => {
        const total = itens.reduce((acc, it) => acc + (it.total || 0), 0);
        const data = new Date();
        const pedido: Pedido = {
          itens,
          validade: data,
          total,
          status: StatusDoPedido.CRIADO
        };
        return pedido;
      })
    );
  }

  buscarPedidos(pagina: number){
    return this.http.get<ListaPedidos>(`${this.baseUrl}?pagina=${pagina}`);
  }

  fazerPedido(){
    // Create the pedido from the store, then POST it to the backend
    return this.criarPedido().pipe(
      switchMap(pedido => this.http.post<Pedido>(this.baseUrl, pedido))
    );
  }

  atualizarPedido(pedido: Pedido):Observable<Pedido>{
    return this.http.put<Pedido>(`${this.baseUrl}/${pedido.id}`, pedido);
  }

}
