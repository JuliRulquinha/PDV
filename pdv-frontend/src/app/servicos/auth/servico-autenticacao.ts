import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { jwtDecode } from 'jwt-decode';

interface JwtPayload {
  sub: string;
  role: string;
  exp?: number;
}

export interface UsuarioLogin{
  nome: string,
  senha: string
}

export interface VerUsuario{
  id?: number,
  nome: string,
  papel: Papel
}

 export enum Papel{
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
  private tokenKey = 'token';

  router = inject(Router);

  isAuthenticated(): boolean {
    const token = localStorage.getItem(this.tokenKey);
    return !!token;
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

  obterPapelUsuario(): string | null {
    const token = localStorage.getItem(this.tokenKey);
    if (!token) return null;

    try {
      const decoded = jwtDecode<any>(token);
      return decoded.papel || decoded.role || decoded.roles || null;
    } catch (e) {
      console.error('Erro ao decodificar token', e);
      return null;
    }
  }

  isAdmin(): boolean{
    return this.obterPapelUsuario() === 'ROLE_ADMIN' ;
  }

  isGerente(): boolean {
    return this.obterPapelUsuario() === 'ROLE_GERENTE';
  }

}
