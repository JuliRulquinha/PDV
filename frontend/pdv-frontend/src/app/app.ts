import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './componentes/header/header';
import { Categorias } from './componentes/categorias/categorias';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, Categorias],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('pdv-frontend');
}
