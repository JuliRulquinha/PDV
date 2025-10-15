import { Component, inject } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import { ServicoAutenticacao } from '../../servicos/auth/servico-autenticacao';

@Component({
  selector: 'app-menu-usuario',
  imports: [MatButtonModule, MatMenuModule, MatIconModule],
  templateUrl: './menu-usuario.html',
  styleUrl: './menu-usuario.css'
})
export class MenuUsuario {

  authService = inject(ServicoAutenticacao);

  sair(){
    this.authService.logout();
  }
}
