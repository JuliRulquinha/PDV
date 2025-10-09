import { Routes } from '@angular/router';
import { PosComponent } from './componentes/pos/pos.component';
import { ControleDeEstoque } from './componentes/controle-de-estoque/controle-de-estoque';
import { PaginaLogin } from './componentes/pagina-login/pagina-login';
import { adminGuard } from './guardas/admin-guard';
import { usuarioGuard } from './guardas/usuario-guard';
import { AcessoNegado } from './componentes/acesso-negado/acesso-negado';


export const routes: Routes = [
    {
        path: '',
        redirectTo: 'checkout',
        pathMatch: 'full'
    },
    {
        path: 'checkout',
        canActivate: [usuarioGuard],
        component: PosComponent 
    },
    {
        path: 'lista-de-produtos',
        canActivate: [adminGuard],
        component: ControleDeEstoque
    },
    {
        path: 'login',
        component: PaginaLogin
    },
    {
        path: 'acesso-negado',
        component: AcessoNegado
    }
];
