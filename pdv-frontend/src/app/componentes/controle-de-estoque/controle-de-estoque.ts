import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { ServicoProduto } from '../../servicos/entities/servico-produto';
import { Produto, Fornecedor, Categoria } from '../pos/pos.component';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ServicoCategoria } from '../../servicos/entities/servico-categoria';
import { ServicoFornecedor } from '../../servicos/entities/servico-fornecedor';

@Component({
  selector: 'app-controle-de-estoque',
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './controle-de-estoque.html',
  styleUrl: './controle-de-estoque.css'
})
export class ControleDeEstoque {
 
  emEdicao:boolean = false; 
  pagina:number = 0;
  contagem:number= 0;
  produtos: Produto[] = [];
  formCadastro!: FormGroup;
  formEdicao!: FormGroup;
  produtoSelecionado: Produto | null = null;
  novoCadastro = false; 
  pageSize: number = 10;  
  totalPaginas: number = 0;
  isLastPage: boolean = false;

  fornecedores: Fornecedor[] = [];

  categorias: Categoria[] = [];

  constructor(
    private servicoProduto: ServicoProduto,
    private servicoCategoria: ServicoCategoria,
    private servicoFornecedor: ServicoFornecedor,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.formCadastro = this.fb.group({
      id: [null],
      nome: ['', Validators.required],
      fornecedor: [Validators.required],
      categoria: [Validators.required],
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
    });
 
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
      this.buscarCategorias(),
      this.buscarFornecedores(),
      this.carregarProdutos()
    ])

   
    
  }

  carregarProdutos(): void {
    this.servicoProduto.buscarProdutos(this.pagina).subscribe({
    next: (data) => {
      this.produtos = Array.isArray(data.produtos) ? data.produtos : [data.produtos];

      this.contagem = data.contagem;
      this.totalPaginas = Math.ceil(this.contagem / this.pageSize);
      // Se retornou menos produtos que o limite → é a última página
      this.isLastPage = this.produtos.length < this.pageSize;
      
    }
  });
  }

  buscarCategorias(): void {
  
    this.servicoCategoria.buscarCategorias().subscribe({
      next: (data) => {
        debugger;
        this.categorias = Array.isArray(data.categorias) ? data.categorias : [data.categorias];
      }
    });
  }

  buscarFornecedores(): void{
    this.servicoFornecedor.buscarFornecedores().subscribe({
      next: (data) => {
        this.fornecedores = Array.isArray(data.fornecedores)? data.fornecedores : [data.fornecedores];
        
      }
    });
  }
  // Chamado quando clica no botão "Cadastrar Produto"
  novoProduto(): void {
    this.novoCadastro = true;
    this.produtoSelecionado = null;

    this.formCadastro.reset({
      quantidade: 0,
      fornecedor: null,
      categoria: null,
      dimensoes: { largura: null, altura: null, profundidade: null }
    });
  }

  editarProduto(p: Produto): void {
    this.emEdicao = true;
    this.produtoSelecionado = p;
    this.novoCadastro = false;
    this.formEdicao.patchValue(p);
  }

 salvarProduto(): void {

  if (this.formCadastro.invalid) {
    this.formCadastro.markAllAsTouched();
    return;
  }

  const produto: Produto = { ...this.formCadastro.value };

  console.log("Produto antes de sair para o backend: ", produto);

  if (produto.validade) {
    produto.validade = new Date(produto.validade);
  }

  if (this.novoCadastro) {
    this.servicoProduto.salvarProduto(produto).subscribe({
      next: (saved) => {
        alert('Produto cadastrado com sucesso!');
        this.carregarProdutos();
        this.cancelarEdicao();
      },
      error: (err) => console.error('Erro ao cadastrar produto', err)
    });
  } else if (this.produtoSelecionado) {
    produto.id = this.produtoSelecionado.id; // garante que o ID está definido
    this.servicoProduto.atualizarProduto(produto).subscribe({
      next: (updated) => {
        alert('Produto atualizado com sucesso');
        this.carregarProdutos();
        this.cancelarEdicao();
      },
      error: (err) => console.error('Erro ao atualizar produto', err)
    });
  }
}

  cancelarEdicao(): void {
    this.emEdicao = false;
    this.produtoSelecionado = null;
    this.novoCadastro = false;
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