import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../components/pos/pos.component';


export interface ListaProdutoDto{
  contagem: number;
  produtos: Produto[],
}

@Injectable({
  providedIn: 'root'
})
export class ServicoProduto {
  baseUrl = "http://localhost:8080/api/produtos";
  http = inject(HttpClient);

  buscarProdutos(pagina: number): Observable<ListaProdutoDto> {
    return this.http.get<ListaProdutoDto>(`${this.baseUrl}?pagina=${pagina}`);
  }

  buscarProdutoPorId(id: number):Observable<Produto>{
    return this.http.get<Produto>(this.baseUrl+"/"+id);
  }

  private mapToCommand(produto: Produto) {
    return {
      nome: produto.nome,
      categoria_id: produto.categoria?.id,
      fornecedor_id: produto.fornecedor?.id,
      marca: produto.marca,
      modelo: produto.modelo,
      quantidade: produto.quantidade,
      valorCusto: produto.valorCusto,
      valorVenda: produto.valorVenda,
      imageUrl: produto.imageUrl,
      validade: produto.validade ? produto.validade.toISOString() : null,
      dimensoes: produto.dimensoes
    };
  }

  // POST /api/produtos
  salvarProduto(product: Produto): Observable<Produto> {
    
    const payload = this.mapToCommand(product);
    return this.http.post<Produto>(this.baseUrl, payload);
  }

  // PUT /api/produtos/{id}
  atualizarProduto(product: Produto): Observable<Produto> {
    if (!product.id) {
      throw new Error("Produto precisa ter um ID para atualizar.");
    }
    const payload = this.mapToCommand(product);
    return this.http.put<Produto>(`${this.baseUrl}/${product.id}`, payload);
  }

}
