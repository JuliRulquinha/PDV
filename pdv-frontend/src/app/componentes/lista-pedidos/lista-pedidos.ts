import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';

import { Pedido, ServicoPedido, VisualizarPedido } from '../../servicos/entities/servico-pedido';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-lista-pedidos',
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './lista-pedidos.html',
  styleUrl: './lista-pedidos.css'
})
export class ListaPedidos {

  emEdicao: boolean= false;
  pagina:number = 0;
  contagem:number= 0;
  pedidos: VisualizarPedido[] = [];
  
  formEdicao!: FormGroup;
  pedidoSelecionado: VisualizarPedido | null = null;
  pageSize: number = 10;  
  totalPaginas: number = 0;
  isLastPage: boolean = false;

  constructor(
    private servicoPedido: ServicoPedido,
   
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
 
     this.formEdicao = this.fb.group({
      cliente: [''],
      itens: [],
      total: [null],
      validade: [null],
    })

    this.carregarPedidos();
  }

  carregarPedidos(): void {
    this.servicoPedido.buscarPedidos(this.pagina).subscribe({
    next: (data) => {
      this.pedidos = Array.isArray(data.pedidos) ? data.pedidos : [data.pedidos];

      this.contagem = data.contagem;
      this.totalPaginas = Math.ceil(this.contagem / this.pageSize);
      // Se retornou menos produtos que o limite → é a última página
      this.isLastPage = this.pedidos.length < this.pageSize;
      
    }
  });
  }

  editarPedido(p: Pedido): void {
    this.emEdicao = true;
    this.pedidoSelecionado = p;
    this.formEdicao.patchValue(p);
  }

  salvarPedido(): void {

  }

  cancelarEdicao(): void {
    this.pedidoSelecionado = null;
    this.emEdicao = false;
    this.formEdicao.reset({ quantidade: 0 });
  }

  proximaPagina(): void {
    if (!this.isLastPage) {
      this.pagina++;
      this.carregarPedidos();
    }
  }

  paginaAnterior(): void {
    if (this.pagina > 0) {
      this.pagina--;
      this.carregarPedidos();
    }
  }

  primeiraPagina(){

    if (this.pagina > 0) {
      this.pagina = 0;
      this.carregarPedidos();
    }

  }

  ultimaPagina(){

    if(!this.isLastPage){
      this.pagina = Math.floor(this.contagem/this.pageSize);
      this.carregarPedidos();
    }
  }

  irParaPagina(p: number): void {
    if (p >= 0 && p < this.totalPaginas) {
      this.pagina = p;
      this.carregarPedidos();
    }

  }

  get paginas(): number[] {
    return Array.from({ length: this.totalPaginas }, (_, i) => i);
  }
}
