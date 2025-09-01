import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './componentes/header/header';
import { Categorias } from './componentes/categorias/categorias';
import { Mostruario } from './componentes/mostruario/mostruario';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, Categorias, Mostruario],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  
}
