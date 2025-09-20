import { Routes } from '@angular/router';
import { PosComponent } from './components/pos/pos.component';
import { ListaProdutos } from './components/lista-produtos/lista-produtos';


export const routes: Routes = [
    // {
    //     path: '',
    //     redirectTo: 'checkout',
    //     pathMatch: 'full'
    // },
    {
        path: 'checkout',
        component: PosComponent 
    },
     {
        path: 'lista-de-produtos',
        component: ListaProdutos
    }
];
