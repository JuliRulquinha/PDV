import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterLink } from '@angular/router';
import { BarraDePesquisa } from '../barra-de-pesquisa/barra-de-pesquisa';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-header',
  imports: [MatToolbarModule,
            MatButtonModule, 
            MatIconModule, 
            MatButtonToggleModule, 
            MatMenuModule,
            RouterLink,
            BarraDePesquisa,
            MatInputModule
          ],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {

}
