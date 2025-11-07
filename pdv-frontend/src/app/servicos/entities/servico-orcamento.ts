import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Produto } from '../../componentes/pos/pos.component';
import { Store } from '@ngrx/store';
import { selectAllProdutos } from '../../store/produto.selectors';
import { filter, map, Observable, tap } from 'rxjs';
import { Cliente } from './servico-cliente';

export interface ListaDeOrcamentos{
  contagem: number,
  orcamentos: Orcamento[]
}

export interface Orcamento{
  id?: number,
  itens: ItemDoOrcamento[],
  cliente_id?: number,
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
  criarOrcamento(cliente?: Cliente): Orcamento {
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

    let dataAtual = new Date();
    let dataProximoMes = new Date(dataAtual);

    dataProximoMes.setMonth(dataProximoMes.getMonth() + 1);

    if(!!cliente){
      return {
        itens: itens,
        cliente_id: cliente.id,
        validade: dataProximoMes,
        total: total,
        status: StatusDoOrcamento.CRIADO
      }
    }

    return {
      itens: itens,
      validade: dataProximoMes,
      total: total,
      status: StatusDoOrcamento.CRIADO
    }
  }

  fazerOrcamento(cliente?: Cliente){
    let orcamento = this.criarOrcamento(cliente);
    return this.http.post<Orcamento>(this.baseUrl, orcamento);
  }

  atualizarOrcamento(orcamento: Orcamento):Observable<Orcamento>{
    return this.http.put<Orcamento>(`${this.baseUrl}/${orcamento.id}`, orcamento);
  }

  buscarOrcamentos(pagina: number){
    return this.http.get<ListaDeOrcamentos>(`${this.baseUrl}?pagina=${pagina}`);
  }

}
