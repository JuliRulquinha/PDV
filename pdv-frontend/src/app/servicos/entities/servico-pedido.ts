import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Produto } from '../../componentes/pos/pos.component';

export interface Pedido{
  id?: number,
  itens: ItemDoPedido[],
  cliente_id?: number,
  validade: number,
  total: number,
  desconto?: number,
  status: StatusDoPedio
}

export interface ItemDoPedido{
  id?: number,
  produto_id: number,
  pedido_id?: number,
  quantidade: number,
  valorUnitario: number,
  total: number
}

export enum StatusDoPedio{
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

  mapearProdutoParaItem(produto: Produto, quantidade: number, totalDosProdutos: number): ItemDoPedido{
    return {
      produto_id: produto.id!,
      quantidade: quantidade!,
      valorUnitario: produto.valorVenda!,
      total: totalDosProdutos!,
    }
  }

  criarPedido(pedido: Pedido){
    return this.http.post<Pedido>(this.baseUrl, pedido);
  }
}
