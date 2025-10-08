import { HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, catchError, throwError } from 'rxjs';
import { ServicoAutenticacao } from './servico-autenticacao';

@Injectable({
  providedIn: 'root'
})
export class InterceptorAutorizacao {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const auth = inject(ServicoAutenticacao);
    const router = inject(Router);

    const token = localStorage.getItem('token');

    const authReq = token
      ? req.clone({ setHeaders: { Authorization: `Bearer ${token}` } })
      : req;

    return next.handle(authReq).pipe(
      catchError((err: HttpErrorResponse) => {
        if (err.status === 401) {
          auth.logout(); // redireciona para login
        }
        return throwError(() => err);
      })
    );
  }
}
