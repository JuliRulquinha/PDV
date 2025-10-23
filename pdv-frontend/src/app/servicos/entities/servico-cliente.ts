import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicoCliente {
  baseUrl = "http://localhost:8080/api/clientes";
  http = inject(HttpClient);
}
