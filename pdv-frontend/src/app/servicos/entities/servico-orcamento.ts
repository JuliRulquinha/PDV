import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Produto } from '../../componentes/pos/pos.component';
import { Store } from '@ngrx/store';
import { selectAllProdutos } from '../../store/produto.selectors';
import { from, map, of, tap } from 'rxjs';

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
  store = inject(Store);

  mapearProdutoParaItem(produto: Produto): ItemDoOrcamento{
    return {
      produto_id: produto.id!,
      quantidade: produto.quantidade!,
      valorUnitario: produto.valorVenda!,
      total: produto.valorVenda! * produto.quantidade,
    }
  }
criarOrcamento() {
  this.store.select(selectAllProdutos).pipe(
    map(produtos => 
      produtos.map(p => this.mapearProdutoParaItem(p))
    ),
    tap(itensMapeados => {
      console.log('Itens mapeados:', itensMapeados);
    })
  )
  .subscribe(itens => {
    console.log('Itens no subscribe:', itens);
    // aqui você já tem os itens prontos
  });
}


  fazerOrcamento(orcamento: Orcamento){
    return this.http.post<Orcamento>(this.baseUrl, orcamento);
  }
}
