import { inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { ServicoAutenticacao } from '../servicos/auth/servico-autenticacao';

export const usuarioGuard: CanActivateFn = () => {
  const authService = inject(ServicoAutenticacao);
  const router = inject(Router);

  // verifica se está autenticado
  if (authService.isAuthenticated()) {
    return true; // pode acessar a rota
  }

  // se não estiver autenticado, redireciona para /login
  router.navigate(['/login']);
  return false;
}
