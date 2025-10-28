import { Routes } from '@angular/router';
import { PosComponent } from './componentes/pos/pos.component';
import { ControleDeEstoque } from './componentes/controle-de-estoque/controle-de-estoque';
import { PaginaLogin } from './componentes/pagina-login/pagina-login';
import { adminGuard } from './guardas/admin-guard';
import { usuarioGuard } from './guardas/usuario-guard';
import { AcessoNegado } from './componentes/acesso-negado/acesso-negado';
import { CadastrarUsuario } from './componentes/cadastrar-usuario/cadastrar-usuario';
import { gerenteGuard } from './guardas/gerente-guard';
import { ListaOrcamentos } from './componentes/lista-orcamentos/lista-orcamentos';


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
        path: 'cadastrar-usuario',
        canActivate: [gerenteGuard],
        component: CadastrarUsuario
    },
    {
        path: 'lista-de-orcamentos',
        canActivate: [usuarioGuard],
        component: ListaOrcamentos
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
