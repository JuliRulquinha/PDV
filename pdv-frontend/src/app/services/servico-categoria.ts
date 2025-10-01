import { inject, Injectable } from '@angular/core';
import { Categoria } from '../components/pos/pos.component';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


export interface ListaCategoriaDto{
  categorias: Categoria[];
}

@Injectable({
  providedIn: 'root'
})
export class ServicoCategoria {
  
  baseUrl = "http://localhost:8080/api/categorias";
  http = inject(HttpClient);

  buscarCategorias(): Observable<ListaCategoriaDto> {
    return this.http.get<ListaCategoriaDto>(`${this.baseUrl}`);
  }

}
