import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterLink } from '@angular/router';
import { BarraDePesquisa } from '../barra-de-pesquisa/barra-de-pesquisa';

@Component({
  selector: 'app-icone-de-usuario',
  imports: [
            MatToolbarModule,
            MatButtonModule, 
            MatIconModule, 
            MatButtonToggleModule, 
            MatMenuModule,
            RouterLink,
            MatInputModule
  ],
  templateUrl: './icone-de-usuario.html',
  styleUrl: './icone-de-usuario.css'
})
export class IconeDeUsuario {

}
