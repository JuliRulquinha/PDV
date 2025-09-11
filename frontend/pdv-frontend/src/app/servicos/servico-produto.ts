import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Produto } from '../componentes/mostruario/mostruario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicoProduto {
  http = inject(HttpClient);
  url = "http://localhost:8080"

  tragaProduto(id: number):Observable<Produto>{
    return this.http.get<Produto>(this.url+"/api/produtos/"+id);
  }


  tragaTodos():Observable<Produto[]>{
    return this.http.get<Produto[]>(this.url+"/api/produtos");
  }
}
