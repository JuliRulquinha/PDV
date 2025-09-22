import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProductService } from '../../services/product-service';
import { Produto, Fornecedor, Categoria } from '../pos/pos.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './lista-produtos.html',
  styleUrls: ['./lista-produtos.css']
})
export class ListaProdutos {
  produtos: Produto[] = [];
  formProduto!: FormGroup;
  produtoSelecionado: Produto | null = null;
  novoCadastro = false; // controla se é cadastro novo

  fornecedores: Fornecedor[] = [
    { id: 1, nome: 'Fornecedor A' },
    { id: 2, nome: 'Fornecedor B' }
  ];

  categorias: Categoria[] = [
    { id: 1, nome: 'Elétrica' },
    { id: 2, nome: 'Hidráulica' },
    { id: 3, nome: 'Ferramentas' }
  ];

  constructor(
    private productService: ProductService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.formProduto = this.fb.group({
      id: [null],
      nome: ['', Validators.required],
      fornecedor: [null, Validators.required],
      categoria: [null, Validators.required],
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
        profundidade: [null]
      })
    });
    var product: Produto = {
      nome: "Cimento Portland CP-II",
  fornecedor: {
    id: 1,
    nome: "Fornecedor ABC"
  },
  categoria: {
    id: 2,
    nome: "Materiais de Construção"
  },
  marca: "Votoran",
  modelo: "CP-II E-32",
  quantidade: 50,
  valorCusto: 28.50,
  valorVenda: 39.90,
  imageUrl: "https://example.com/images/cimento.jpg",
  validade: new Date("2026-12-31"),
  dimensoes: {
    largura: 30,
    altura: 50,
    peso: 15
  }
    };
   
       this.productService.saveProduct(product).subscribe(saved => {
    console.log("Produto salvo:", saved);
  
    });
    

    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe({
      next: (data) => {
        this.produtos = Array.isArray(data) ? data : [data];
      },
      error: (err) => console.error('Erro ao carregar produtos', err)
    });
  }

  // Chamado quando clica no botão "Cadastrar Produto"
  novoProduto(): void {
    this.novoCadastro = true;
    this.produtoSelecionado = null;

    this.formProduto.reset({
      quantidade: 0,
      fornecedor: null,
      categoria: null,
      dimensoes: { largura: null, altura: null, profundidade: null }
    });
  }

  editarProduto(p: Produto): void {
    this.produtoSelecionado = p;
    this.novoCadastro = false;
    this.formProduto.patchValue(p);
  }

 salvarProduto(): void {
  console.log('submit disparado', this.formProduto.value);

  if (this.formProduto.invalid) {
    this.formProduto.markAllAsTouched();
    return;
  }

  const produto: Produto = { ...this.formProduto.value };

  // Converte validade para Date se veio como string do input
  if (produto.validade) {
    produto.validade = new Date(produto.validade);
  }

  if (this.novoCadastro) {
    this.productService.saveProduct(produto).subscribe({
      next: (saved) => {
        console.log('Produto cadastrado:', saved);
        this.loadProducts();
        this.cancelarEdicao();
      },
      error: (err) => console.error('Erro ao cadastrar produto', err)
    });
  } else if (this.produtoSelecionado) {
    produto.id = this.produtoSelecionado.id; // garante que o ID está definido
    this.productService.updateProduct(produto).subscribe({
      next: (updated) => {
        console.log('Produto atualizado:', updated);
        this.loadProducts();
        this.cancelarEdicao();
      },
      error: (err) => console.error('Erro ao atualizar produto', err)
    });
  }
}

  cancelarEdicao(): void {
    this.produtoSelecionado = null;
    this.novoCadastro = false;
    this.formProduto.reset({ quantidade: 0 });
  }
}
