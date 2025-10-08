import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

export interface UsuarioLogin{
  nome: string,
  senha: string
}

export interface VerUsuario{
  id?: number,
  nome: string,
  papel: Papel
}

 enum Papel{
    ADMIN,
    USUARIO,
    GERENTE
 }

@Injectable({
  providedIn: 'root'
})

export class ServicoAutenticacao{
  http = inject(HttpClient);
  baseUrl = "http://localhost:8080/api/auth";
  private tokenKey = 'token'; // nome no localStorage

  router = inject(Router);

  isAuthenticated(): boolean {
    const token = localStorage.getItem(this.tokenKey);
    return !!token; // retorna true se existir token
  }

  salvarToken(token: string) {
    localStorage.setItem(this.tokenKey, token);
  }

  logout() {
    localStorage.removeItem(this.tokenKey);
    this.router.navigate(['/login']);
  }

  autenticar(usuario: UsuarioLogin): Observable<{ token: string }> {
  return this.http.post<{ token: string }>(this.baseUrl+"/login", usuario);
}

  // isAuthenticated(){

  // }
}
