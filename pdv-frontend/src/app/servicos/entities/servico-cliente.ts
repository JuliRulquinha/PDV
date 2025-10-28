import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';


export interface Cliente{
  id: number,
  nome: string,
  telefone: string,
  email: string,
  enderecos: Endereco[]
}

export interface Endereco{
  rua: string,
  numero: number,
  cep: string,
  complemento: string
}

@Injectable({
  providedIn: 'root'
})
export class ServicoCliente {
  baseUrl = "http://localhost:8080/api/clientes";
  http = inject(HttpClient);
}
