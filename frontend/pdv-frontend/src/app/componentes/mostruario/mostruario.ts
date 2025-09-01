import { Component } from '@angular/core';
import { Categoria } from '../categorias/categorias';

export interface Dimensoes {
  altura: number;
  largura: number;
  peso: number;
}

export interface Produto {
  id?: number;
  preco: number;        
  nome: string;
  categoria: Categoria; 
  marca: string;
  modelo: string;
  quantidade: number;
  imageUrl: string;
  dimensoes: Dimensoes;
}

@Component({
  selector: 'app-mostruario',
  imports: [],
  templateUrl: './mostruario.html',
  styleUrl: './mostruario.css'
})
export class Mostruario {

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

 produtos: Produto[] = [
  {
    id: 1,
    preco: 4500,
    nome: "Notebook Dell Inspiron",
    categoria: this.categorias[0],
    marca: "Dell",
    modelo: "Inspiron 15 3000",
    quantidade: 15,
    imageUrl: "https://picsum.photos/200?random=1",
    dimensoes: { altura: 2, largura: 35, peso: 1.8 }
  },
  {
    id: 2,
    preco: 3500,
    nome: "Smartphone Samsung Galaxy",
    categoria: this.categorias[0],
    marca: "Samsung",
    modelo: "Galaxy S21",
    quantidade: 25,
    imageUrl: "https://picsum.photos/200?random=2",
    dimensoes: { altura: 0.8, largura: 7.5, peso: 0.18 }
  },
  {
    id: 3,
    preco: 150,
    nome: "Bola de Futebol Nike",
    categoria: this.categorias[1],
    marca: "Nike",
    modelo: "Strike",
    quantidade: 50,
    imageUrl: "https://picsum.photos/200?random=3",
    dimensoes: { altura: 22, largura: 22, peso: 0.43 }
  },
  {
    id: 4,
    preco: 600,
    nome: "Tênis de Corrida Adidas",
    categoria: this.categorias[1],
    marca: "Adidas",
    modelo: "Ultraboost",
    quantidade: 30,
    imageUrl: "https://picsum.photos/200?random=4",
    dimensoes: { altura: 12, largura: 30, peso: 0.9 }
  },
  {
    id: 5,
    preco: 120,
    nome: "Camisa Social Masculina",
    categoria: this.categorias[2],
    marca: "Zara",
    modelo: "Slim Fit",
    quantidade: 40,
    imageUrl: "https://picsum.photos/200?random=5",
    dimensoes: { altura: 2, largura: 30, peso: 0.3 }
  },
  {
    id: 6,
    preco: 180,
    nome: "Vestido Feminino Longo",
    categoria: this.categorias[2],
    marca: "H&M",
    modelo: "Summer Dress",
    quantidade: 20,
    imageUrl: "https://picsum.photos/200?random=6",
    dimensoes: { altura: 2, largura: 35, peso: 0.5 }
  },
  {
    id: 7,
    preco: 80,
    nome: "Caixa de Chocolates Lindt",
    categoria: this.categorias[3],
    marca: "Lindt",
    modelo: "Swiss Luxury",
    quantidade: 60,
    imageUrl: "https://picsum.photos/200?random=7",
    dimensoes: { altura: 5, largura: 25, peso: 0.4 }
  },
  {
    id: 8,
    preco: 25,
    nome: "Pacote de Café Pilão",
    categoria: this.categorias[3],
    marca: "Pilão",
    modelo: "500g",
    quantidade: 80,
    imageUrl: "https://picsum.photos/200?random=8",
    dimensoes: { altura: 20, largura: 10, peso: 0.5 }
  },
  {
    id: 9,
    preco: 2200,
    nome: "Sofá de 3 Lugares",
    categoria: this.categorias[4],
    marca: "Tok&Stok",
    modelo: "Confort Plus",
    quantidade: 5,
    imageUrl: "https://picsum.photos/200?random=9",
    dimensoes: { altura: 85, largura: 200, peso: 40 }
  },
  {
    id: 10,
    preco: 1500,
    nome: "Cadeira Gamer",
    categoria: this.categorias[4],
    marca: "DXRacer",
    modelo: "Formula Series",
    quantidade: 12,
    imageUrl: "https://picsum.photos/200?random=10",
    dimensoes: { altura: 120, largura: 70, peso: 25 }
  },
  {
    id: 11,
    preco: 90,
    nome: "Livro Senhor dos Anéis",
    categoria: this.categorias[5],
    marca: "HarperCollins",
    modelo: "Edição Especial",
    quantidade: 35,
    imageUrl: "https://picsum.photos/200?random=11",
    dimensoes: { altura: 23, largura: 16, peso: 0.9 }
  },
  {
    id: 12,
    preco: 450,
    nome: "Kindle Paperwhite",
    categoria: this.categorias[5],
    marca: "Amazon",
    modelo: "Paperwhite 11ª Geração",
    quantidade: 18,
    imageUrl: "https://picsum.photos/200?random=12",
    dimensoes: { altura: 1, largura: 12, peso: 0.2 }
  },
  {
    id: 13,
    preco: 700,
    nome: "Violão Acústico Yamaha",
    categoria: this.categorias[6],
    marca: "Yamaha",
    modelo: "F310",
    quantidade: 10,
    imageUrl: "https://picsum.photos/200?random=13",
    dimensoes: { altura: 105, largura: 40, peso: 2.5 }
  },
  {
    id: 14,
    preco: 3500,
    nome: "Bateria Eletrônica Roland",
    categoria: this.categorias[6],
    marca: "Roland",
    modelo: "TD-1DMK",
    quantidade: 6,
    imageUrl: "https://picsum.photos/200?random=14",
    dimensoes: { altura: 100, largura: 120, peso: 20 }
  },
  {
    id: 15,
    preco: 70,
    nome: "Batom Vermelho",
    categoria: this.categorias[7],
    marca: "MAC",
    modelo: "Ruby Woo",
    quantidade: 70,
    imageUrl: "https://picsum.photos/200?random=15",
    dimensoes: { altura: 8, largura: 2, peso: 0.03 }
  },
  {
    id: 16,
    preco: 35,
    nome: "Creme Hidratante Nivea",
    categoria: this.categorias[7],
    marca: "Nivea",
    modelo: "Soft 200ml",
    quantidade: 55,
    imageUrl: "https://picsum.photos/200?random=16",
    dimensoes: { altura: 8, largura: 8, peso: 0.2 }
  },
  {
    id: 17,
    preco: 500,
    nome: "Lego Star Wars",
    categoria: this.categorias[8],
    marca: "LEGO",
    modelo: "Millennium Falcon",
    quantidade: 14,
    imageUrl: "https://picsum.photos/200?random=17",
    dimensoes: { altura: 30, largura: 50, peso: 2 }
  },
  {
    id: 18,
    preco: 120,
    nome: "Quebra-Cabeça 1000 Peças",
    categoria: this.categorias[8],
    marca: "Grow",
    modelo: "Paisagem da Toscana",
    quantidade: 22,
    imageUrl: "https://picsum.photos/200?random=18",
    dimensoes: { altura: 5, largura: 40, peso: 0.7 }
  },
  {
    id: 19,
    preco: 800,
    nome: "Pneu Michelin Aro 16",
    categoria: this.categorias[9],
    marca: "Michelin",
    modelo: "Primacy 4",
    quantidade: 20,
    imageUrl: "https://picsum.photos/200?random=19",
    dimensoes: { altura: 60, largura: 60, peso: 8 }
  },
  {
    id: 20,
    preco: 200,
    nome: "Kit Óleo de Motor",
    categoria: this.categorias[9],
    marca: "Mobil",
    modelo: "5W30 4L",
    quantidade: 30,
    imageUrl: "https://picsum.photos/200?random=20",
    dimensoes: { altura: 30, largura: 15, peso: 4 }
  }
];


}
