import { Routes } from '@angular/router';
import { PaginaDeLogin } from './componentes/pagina-de-login/pagina-de-login';

export const routes: Routes = [
    {
        path: "",
        redirectTo: "/login",
        pathMatch: "full"
    }
    ,
    {
        path: "*",
        redirectTo: "/login"
    }
    ,
    {
        path: "login",
        component: PaginaDeLogin,
        pathMatch: "full"
    }
];
