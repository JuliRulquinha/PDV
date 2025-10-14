import { inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { ServicoAutenticacao } from '../servicos/auth/servico-autenticacao';

export const usuarioGuard: CanActivateFn = () => {
  const authService = inject(ServicoAutenticacao);
  const router = inject(Router);

  if (authService.isAuthenticated()) {
    return true; 
  }

  router.navigate(['/login']);
  return false;
}
