import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../components/pos/pos.component';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  http = inject(HttpClient);

  getProducts(): Observable<Produto[]> {
  return this.http.get<Produto[]>("http://localhost:8080/api/produtos");
}

  getProductById(id: number):Observable<Produto>{
    return this.http.get<Produto>("http://localhost:8080/api/produtos/"+id);
  }
}
