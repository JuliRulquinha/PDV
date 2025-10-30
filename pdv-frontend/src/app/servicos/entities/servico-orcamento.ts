import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Produto } from '../../componentes/pos/pos.component';
import { Store } from '@ngrx/store';
import { selectAllProdutos } from '../../store/produto.selectors';
import { filter, map, Observable, tap } from 'rxjs';
import { Cliente } from './servico-cliente';

export interface Orcamento{
  id?: number,
  itens: ItemDoOrcamento[],
  cliente?: Cliente,
  validade: Date,
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
  total: number
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
  baseUrl = "http://localhost:8080/api/orcamentos";
  http = inject(HttpClient);
  store = inject(Store);

  mapearProdutoParaItem(produto: Produto): ItemDoOrcamento{
    return {
      produto_id: produto.id!,
      quantidade: produto.quantidade!,
      valorUnitario: produto.valorVenda!,
      total: produto.valorVenda! * produto.quantidade,
    }
  }
  criarOrcamento(): Orcamento {
    let itens: ItemDoOrcamento[] = [];
    let total: number = 0;
    this.store.select(selectAllProdutos).pipe(
      filter(produtos => produtos.length > 0),
      map(produtos => 
        produtos.map(p => this.mapearProdutoParaItem(p))
      ),
      tap(itensMapeados => {
        console.log('Itens mapeados:', itensMapeados);
      })
    )
    .subscribe(itensDoStore => {
      itens = itensDoStore;

      for(var i of itens){
        total += i.total;
      }
      
    });

    let data = new Date();
    return {
      itens: itens,
      validade: data,
      total: total,
      status: StatusDoOrcamento.CRIADO
    }
  }

   fazerOrcamento(){
    let orcamento = this.criarOrcamento();
    return this.http.post<Orcamento>(this.baseUrl, orcamento);
  }

  atualizarOrcamento(orcamento: Orcamento):Observable<Orcamento>{
    return new Observable<Orcamento>;
  }

}
