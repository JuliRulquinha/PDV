import { Routes } from '@angular/router';
import { PosComponent } from './components/pos/pos.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '/checkout',
        pathMatch: 'full'
    },
    {
        path: 'checkout',
        component: PosComponent,
        pathMatch: 'full'
    }
];
