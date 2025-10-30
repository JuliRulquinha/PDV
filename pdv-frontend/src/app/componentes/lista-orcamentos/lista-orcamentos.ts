import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';

import { Orcamento, ServicoOrcamento } from '../../servicos/entities/servico-orcamento';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-lista-orcamentos',
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './lista-orcamentos.html',
  styleUrl: './lista-orcamentos.css'
})
export class ListaOrcamentos {

  emEdicao: boolean= false;
  pagina:number = 0;
  contagem:number= 0;
  orcamentos: Orcamento[] = [];
  
  formEdicao!: FormGroup;
  orcamentoSelecionado: Orcamento | null = null;
  pageSize: number = 10;  
  totalPaginas: number = 0;
  isLastPage: boolean = false;

  constructor(
    private servicoOrcamento: ServicoOrcamento,
   
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
 
    this.formEdicao = this.fb.group({
      id: [null],
      nome: ['', Validators.required],
      marca: [''],
      modelo: [''],
      quantidade: [0, [Validators.required, Validators.min(0)]],
      valorCusto: [null],
      valorVenda: [null],
      imageUrl: [''],
      validade: [null],
      dimensoes: this.fb.group({
        largura: [null],
        altura: [null],
        peso: [null]
      })
    })

    Promise.all([
      
    ])
  }

  carregarProdutos(): void {
  //   this.servicoOrcamento.buscarProdutos(this.pagina).subscribe({
  //   next: (data) => {
  //     this.produtos = Array.isArray(data.produtos) ? data.produtos : [data.produtos];

  //     this.contagem = data.contagem;
  //     this.totalPaginas = Math.ceil(this.contagem / this.pageSize);
  //     // Se retornou menos produtos que o limite → é a última página
  //     this.isLastPage = this.produtos.length < this.pageSize;
      
  //   }
  // });
  }

  
  editarOrcamento(o: Orcamento): void {
    this.emEdicao = true;
    this.orcamentoSelecionado = o;
    this.formEdicao.patchValue(o);
  }

  salvarOrcamento(): void {

  // if (this.formEdicao.invalid) {
  //   this.formEdicao.markAllAsTouched();
  //   return;
  // }

  // const orcamento: Orcamento = { ...this.formEdicao.value };

  // console.log("Orçamento antes de sair para o backend: ", orcamento);

  // if (orcamento.validade) {
  //   //orcamento.validade = new Date(orcamento.validade);
  // }

  // if (this.emEdicao) {
  //   this.servicoOrcamento.fazerOrcamento().subscribe({
  //     next: (saved) => {
  //       alert('Produto cadastrado com sucesso!');
  //       this.carregarProdutos();
  //       this.cancelarEdicao();
  //     },
  //     error: (err) => console.error('Erro ao cadastrar produto', err)
  //   });
  // } else if (this.orcamentoSelecionado) {
  //   orcamento.id = this.orcamentoSelecionado.id; // garante que o ID está definido
  //   this.servicoOrcamento.atualizarOrcamento(orcamento).subscribe({
  //     next: (updated) => {
  //       alert('Produto atualizado com sucesso');
  //       this.carregarProdutos();
  //       this.cancelarEdicao();
  //     },
  //     error: (err) => console.error('Erro ao atualizar produto', err)
  //   });
  // }
}

  cancelarEdicao(): void {
    this.orcamentoSelecionado = null;
    this.emEdicao = false;
    this.formEdicao.reset({ quantidade: 0 });
  }

  proximaPagina(): void {
    if (!this.isLastPage) {
      this.pagina++;
      this.carregarProdutos();
    }
  }

  paginaAnterior(): void {
    if (this.pagina > 0) {
      this.pagina--;
      this.carregarProdutos();
    }
  }

  primeiraPagina(){

    if (this.pagina > 0) {
      this.pagina = 0;
      this.carregarProdutos();
    }

  }

  ultimaPagina(){

    if(!this.isLastPage){
      this.pagina = Math.floor(this.contagem/this.pageSize);
      this.carregarProdutos();
    }
  }

  irParaPagina(p: number): void {
    if (p >= 0 && p < this.totalPaginas) {
      this.pagina = p;
      this.carregarProdutos();
    }

  }

  get paginas(): number[] {
    return Array.from({ length: this.totalPaginas }, (_, i) => i);
  }
}
