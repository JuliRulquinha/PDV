import { Component, EventEmitter, inject, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { Cliente, ServicoCliente } from '../../servicos/entities/servico-cliente';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ServicoOrcamento } from '../../servicos/entities/servico-orcamento';
import { ServicoPedido } from '../../servicos/entities/servico-pedido';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { MatIconModule } from '@angular/material/icon';
import {AsyncPipe} from '@angular/common';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule, 
    MatSnackBarModule, 
    MatIconModule, 
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule
  ],
  templateUrl: './clientes.html',
  styleUrl: './clientes.css'
})
export class Clientes implements OnInit {

  @Input() tipoDeCriacao?: 'pedido' | 'orcamento';
  @Output() pularInputDeCliente = new EventEmitter();

  fb = inject(FormBuilder);
  servicoCliente = inject(ServicoCliente);
  servicoOrcamento = inject(ServicoOrcamento);
  servicoPedido = inject(ServicoPedido);
  router = inject(Router);
  snackBar = inject(MatSnackBar);
  
  clientes: Cliente[] = [];
  clienteSelecionado?: Cliente;

  cadastroForm: FormGroup = this.fb.group({
    nome: ['', [Validators.required, Validators.minLength(3)]],
    telefone: ['', Validators.required],
    endereco: ['']
  });

  submitted = false;
  erroCadastro = false;


  ngOnInit(): void {
    this.cadastroForm.get('nome')?.valueChanges.subscribe(valor => {
      // Se o valor for um objeto Cliente, não dispara a busca
      if (typeof valor === 'string' && valor.length >= 2) {
        this.buscarPossiveisClientes(valor);
      }
    });
  }

  buscarClientes() {
    this.servicoCliente.buscar().subscribe(clientesDoDb => {
      this.clientes = clientesDoDb;
    });
  }

  cadastrar() {
    this.submitted = true;

    if (this.cadastroForm.invalid) {
      this.cadastroForm.markAllAsTouched();
      return;
    }

    const cliente = this.cadastroForm.value;

    debugger;
    if(!this.clienteSelecionado){
      this.servicoCliente.cadastrar(cliente).subscribe({
      next: (resposta) => {
        this.erroCadastro = false;
        this.showSuccess('Cliente cadastrado com sucesso!');
        console.log('Cliente cadastrado: ', resposta);
        this.cadastroForm.reset();
      },
      error: (erro) => {
        if (erro.status === 403) {
          this.erroCadastro = true;
          this.showError('Você não tem permissão para cadastrar este cliente.');
        } else {
          this.showError('Ocorreu um erro inesperado. Tente novamente.');
        }
      }, complete: () =>{
        this.cadastroForm.reset();
        this.cadastroForm.clearValidators();
        this.servicoCliente.notificarConclusao();
      }
    });}
    this.cadastroForm.reset();
    this.cadastroForm.clearValidators();
    this.servicoCliente.notificarConclusao();
  }

  selecionarCliente(cliente: Cliente) {
    if (!cliente) return;
    
    // Atualiza os campos do formulário
    this.clienteSelecionado = cliente;
    this.cadastroForm.patchValue({
      nome: cliente.nome,  // Passa o objeto cliente completo
      telefone: cliente.telefone || '',
      endereco: cliente.endereco || ''
    });

    // Marca o form como touched para habilitar o botão de confirmar
    this.cadastroForm.markAsTouched();
  }

  confirmar() {
    if (this.tipoDeCriacao === 'orcamento') {
      return this.salvarOrcamento();
    }

    if (this.tipoDeCriacao === 'pedido') {
      return this.salvarPedido();
    }
  }

  salvarPedido() {
    if (confirm('Deseja finalizar a compra?')) {
      this.servicoPedido.fazerPedido(this.clienteSelecionado).subscribe({
        next: () => this.showSuccess('Pedido finalizado com sucesso!'),
        error: () => this.showError('Falha ao finalizar o pedido.')
      });
    }
  }

  salvarOrcamento() {
    if (confirm('Deseja salvar o orçamento?')) {
      
      this.servicoOrcamento.fazerOrcamento(this.clienteSelecionado).subscribe({
        next: () => this.showSuccess('Orçamento salvo com sucesso!'),
        error: () => this.showError('Falha ao salvar o orçamento.')
      });
    }
  }

  pular() {
    console.log(this.tipoDeCriacao);
    if (this.tipoDeCriacao === 'orcamento') {
      return this.salvarOrcamento();
    }

    if (this.tipoDeCriacao === 'pedido') {
      return this.salvarPedido();
    }

    this.pularInputDeCliente.emit();
  }

  buscarPossiveisClientes(nome: string){
    this.servicoCliente.buscarPorNome(nome).subscribe({
      next: (data) => {
      this.clientes = Array.isArray(data.clientes) ? data.clientes : [data.clientes];
      console.log(this.clientes);
    }});

    //return this.clientes.filter(c => c.nome.includes(nome));
  }

  showSuccess(message: string) {
    this.snackBar.open(message, 'OK', {
      duration: 3000,
      panelClass: ['snackbar-success']
    });
  }

  showError(message: string) {
    this.snackBar.open(message, 'Fechar', {
      duration: 4000,
      panelClass: ['snackbar-error']
    });
  }

  displayFn(cliente: Cliente | string | null): string {
    if (!cliente) return '';
    return typeof cliente === 'object' ? cliente.nome : cliente;
  }
}
