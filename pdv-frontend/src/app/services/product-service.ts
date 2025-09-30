import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../components/pos/pos.component';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  baseUrl = "http://localhost:8080/api/produtos";
  http = inject(HttpClient);

  getProducts(pagina: number): Observable<Produto[]> {
    return this.http.get<Produto[]>(`${this.baseUrl}?pagina=${pagina}`);
  }

  getProductById(id: number):Observable<Produto>{
    return this.http.get<Produto>(this.baseUrl+"/"+id);
  }

  private mapToCommand(product: Produto) {
    return {
      nome: product.nome,
      categoria_id: product.categoria?.id,
      fornecedor_id: product.fornecedor?.id,
      marca: product.marca,
      modelo: product.modelo,
      quantidade: product.quantidade,
      valorCusto: product.valorCusto,
      valorVenda: product.valorVenda,
      imageUrl: product.imageUrl,
      validade: product.validade ? product.validade.toISOString() : null,
      dimensoes: product.dimensoes
    };
  }

  // POST /api/produtos
  saveProduct(product: Produto): Observable<Produto> {
    
    const payload = this.mapToCommand(product);
    return this.http.post<Produto>(this.baseUrl, payload);
  }

  // PUT /api/produtos/{id}
  updateProduct(product: Produto): Observable<Produto> {
    if (!product.id) {
      throw new Error("Produto precisa ter um ID para atualizar.");
    }
    const payload = this.mapToCommand(product);
    return this.http.put<Produto>(`${this.baseUrl}/${product.id}`, payload);
  }

}
