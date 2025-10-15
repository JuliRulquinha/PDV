import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Papel, VerUsuario } from './servico-autenticacao';
import { Observable } from 'rxjs';

export interface UsuarioCadastro{
  nome: string;
  papel: Papel;
  senha: string
}

@Injectable({
  providedIn: 'root'
})
export class ServicoUsuario {

  http = inject(HttpClient);
  baseUrl = "http://localhost:8080/api/usuarios";

  cadastrar(usuario: UsuarioCadastro){
    return this.http.post(this.baseUrl + "/cadastrar", usuario);
  }
}
