import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { ServicoAutenticacao } from '../servicos/auth/servico-autenticacao';

export const gerenteGuard: CanActivateFn = (route, state) => {
  const authService = inject(ServicoAutenticacao);
  const router = inject(Router);

  if (!authService.isAuthenticated()) {
    router.navigate(['/login']);
    return false;
  }

  const papel = authService.obterPapelUsuario()?.toUpperCase();
  console.log(papel);

  if (papel === 'ROLE_GERENTE') {
    return true; 
  }

  router.navigate(['/acesso-negado']);
  return false;
};
