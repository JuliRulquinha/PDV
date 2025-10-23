import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicoOrcamento {
  baseUrl = "http://localhost:8080/api/orcamento";
  http = inject(HttpClient);
}
