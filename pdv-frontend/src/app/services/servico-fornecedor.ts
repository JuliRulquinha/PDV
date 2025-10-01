import { inject, Injectable } from '@angular/core';
import { Fornecedor } from '../components/pos/pos.component';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ListaFornecedorDto{
  fornecedores: Fornecedor[];
}

@Injectable({
  providedIn: 'root'
})
export class ServicoFornecedor {
   baseUrl = "http://localhost:8080/api/fornecedores";
  http = inject(HttpClient);

  buscarFornecedores(): Observable<ListaFornecedorDto> {
    return this.http.get<ListaFornecedorDto>(`${this.baseUrl}`);
  }
}
