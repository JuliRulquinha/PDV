import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Produto } from '../../componentes/pos/pos.component';

export interface Orcamento{
  id?: number,
  itens: ItemDoOrcamento[],
  cliente_id?: number,
  validade: number,
  total: number,
  desconto?: number,
  status: StatusDoOrcamento
}

export interface ItemDoOrcamento{
  id?:number,
  orcamento_id?: number,
  produto_id: number,
  quantidade: number,
  valorUnitario: number | undefined,
  total: number | undefined
}

export enum StatusDoOrcamento{
  CRIADO,
  EXPIRADO,
  CANCELADO
}

@Injectable({
  providedIn: 'root'
})
export class ServicoOrcamento {
  baseUrl = "http://localhost:8080/api/orcamento";
  http = inject(HttpClient);

  mapearProdutoParaItem(produto: Produto, quantidade: number, totalDosProdutos: number): ItemDoOrcamento{
    return {
      produto_id: produto.id!,
      quantidade: quantidade!,
      valorUnitario: produto.valorVenda!,
      total: totalDosProdutos!,
    }
  }

  fazerOrcamento(orcamento: Orcamento){
    return this.http.post<Orcamento>(this.baseUrl, orcamento);
  }
}
