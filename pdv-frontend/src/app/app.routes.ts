import { Routes } from '@angular/router';
import { PosComponent } from './components/pos/pos.component';
import { ControleDeEstoque } from './components/controle-de-estoque/controle-de-estoque';
import { PaginaLogin } from './components/pagina-login/pagina-login';


export const routes: Routes = [
    {
        path: '',
        redirectTo: 'checkout',
        pathMatch: 'full'
    },
    {
        path: 'checkout',
        component: PosComponent 
    },
    {
        path: 'lista-de-produtos',
        component: ControleDeEstoque
    },
    {
        path: 'login',
        component: PaginaLogin
    }
];
