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

export interface UsuarioLogin {
  nome: string;
  senha: string;
}

export interface VerUsuario {
  id?: number;
  nome: string;
  papel: Papel;
}

export enum Papel {
  ADMIN,
  USUARIO,
  GERENTE
}

@Injectable({
  providedIn: 'root'
})
export class ServicoAutenticacao {

  http = inject(HttpClient);
  router = inject(Router);

  private baseUrl = "http://localhost:8080/api/auth";
  private tokenKey = 'token';
  private logoutTimer?: any;

  autenticar(usuario: UsuarioLogin): Observable<{ token: string }> {
    return this.http.post<{ token: string }>(`${this.baseUrl}/login`, usuario);
  }

  salvarToken(token: string) {
    localStorage.setItem(this.tokenKey, token);
    this.configurarLogoutAutomatico(token);
  }

  private configurarLogoutAutomatico(token: string) {

    if (this.logoutTimer) {
      clearTimeout(this.logoutTimer);
    }

    const exp = this.obterExpiracaoToken(token);
    if (exp) {
      const tempoRestante = exp - Date.now();
      if (tempoRestante > 0) {
        this.logoutTimer = setTimeout(() => {
          this.logout();
        }, tempoRestante);
      } else {
        // token already expired
        this.logout();
      }
    }
  }

  private obterExpiracaoToken(token?: string): number | null {
    try {
      if (!token) token = localStorage.getItem(this.tokenKey) ?? '';
      if (!token) return null;
      const decoded = jwtDecode<JwtPayload>(token);
      if (!decoded.exp) return null;
      return decoded.exp * 1000; // convert to ms
    } catch {
      return null;
    }
  }

  isAuthenticated(): boolean {
    const token = localStorage.getItem(this.tokenKey);
    if (!token) return false;

    const exp = this.obterExpiracaoToken(token);
    if (!exp || Date.now() >= exp) {
      this.logout();
      return false;
    }
    return true;
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

  isAdmin(): boolean {
    return this.obterPapelUsuario() === 'ROLE_ADMIN';
  }

  isGerente(): boolean {
    return this.obterPapelUsuario() === 'ROLE_GERENTE';
  }

  logout() {
    localStorage.removeItem(this.tokenKey);
    if (this.logoutTimer) clearTimeout(this.logoutTimer);
    this.router.navigate(['/login']);
  }
}
