import { Component, ElementRef, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';

export interface Categoria {
  nome : string;
  descricao: string;
  icone: string;
}

@Component({
  selector: 'app-categorias',
  imports: [MatButtonModule, MatDividerModule, MatIconModule, MatTabsModule, MatButtonModule, MatIconModule],
  templateUrl: './categorias.html',
  styleUrl: './categorias.css'
})
export class Categorias {

  @ViewChild('scrollContainer') scrollContainer!: ElementRef;

  scrollLeft() {
    this.scrollContainer.nativeElement.scrollBy({ left: -200, behavior: 'smooth' });
  }

  scrollRight() {
    this.scrollContainer.nativeElement.scrollBy({ left: 200, behavior: 'smooth' });
  }

  categorias: Categoria[] = [
    { nome: 'Tecnologia', descricao: 'Produtos e serviços de tecnologia.', icone: 'devices' },
    { nome: 'Esportes', descricao: 'Artigos e equipamentos esportivos.', icone: 'sports_soccer' },
    { nome: 'Roupas', descricao: 'Moda masculina e feminina.', icone: 'checkroom' },
    { nome: 'Alimentos', descricao: 'Comidas, bebidas e ingredientes.', icone: 'restaurant' },
    { nome: 'Móveis', descricao: 'Móveis para casa e escritório.', icone: 'weekend' },
    { nome: 'Livros', descricao: 'Livros físicos e digitais.', icone: 'menu_book' },
    { nome: 'Música', descricao: 'Instrumentos e acessórios musicais.', icone: 'music_note' },
    { nome: 'Beleza', descricao: 'Produtos de beleza e cuidados pessoais.', icone: 'face_retouching_natural' },
    { nome: 'Brinquedos', descricao: 'Jogos e brinquedos infantis.', icone: 'toys' },
    { nome: 'Automóveis', descricao: 'Peças e acessórios para veículos.', icone: 'directions_car' }
  ];

}
