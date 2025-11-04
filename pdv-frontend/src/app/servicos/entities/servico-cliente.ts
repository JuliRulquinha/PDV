import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

export interface ListaDeClientes{
  clientes: Cliente[]
}

export interface Cliente{
  id?: number,
  nome: string,
  telefone: string,
  email?: string,
  enderecos?: Endereco[]
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

  buscar(){
    return this.http.get<Cliente[]>(this.baseUrl);
  }

  buscarPorNome(nome: string){
    return this.http.post<ListaDeClientes>(this.baseUrl, nome,
    {
      headers: { 'Content-Type': 'text/plain' }
    });
  }

  buscarPorId(id: number){
    return this.http.get<Cliente>(`${this.baseUrl}/${id}`);
  }

  cadastrar(cliente: Cliente){
    return this.http.post(this.baseUrl+"/cadastrar", cliente);
  }

}
