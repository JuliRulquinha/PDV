import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicoPedido {
  baseUrl = "http://localhost:8080/api/pedidos";
  http = inject(HttpClient);

}
