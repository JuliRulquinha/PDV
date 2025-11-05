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
    MatAutocompleteModule,
    AsyncPipe
  ],
  templateUrl: './clientes.html',
  styleUrl: './clientes.css'
})
export class Clientes implements OnInit {

  ngOnInit(): void {
      this.cadastroForm.get('nome')?.valueChanges.subscribe(valor => {
      if (valor && valor.length >= 2) {
        var clientes = this.buscarPossiveisClientes(valor);
        console.log(clientes);
      }
    });
  }

  @Input() tipoDeCriacao?: 'pedido' | 'orcamento';
  @Output() pularInputDeCliente = new EventEmitter();

  fb = inject(FormBuilder);
  servicoCliente = inject(ServicoCliente);
  servicoOrcamento = inject(ServicoOrcamento);
  servicoPedido = inject(ServicoPedido);
  router = inject(Router);
  snackBar = inject(MatSnackBar);
  
  clientes: Cliente[] = [
    { nome: 'Juliana Souza', telefone: '11987654321', endereco: 'Rua das Flores, 120' },
    { nome: 'Julius Ferreira', telefone: '21988776655', endereco: 'Avenida Central, 45' },
    { nome: 'Julio Andrade', telefone: '31999887766', endereco: 'Rua São Pedro, 78' },
    { nome: 'Juliette Lima', telefone: '41988779966', endereco: 'Praça da Paz, 12' },
    { nome: 'Marcos Silva', telefone: '11955667788', endereco: 'Rua Nova Esperança, 100' },
    { nome: 'Carla Menezes', telefone: '21966554433', endereco: 'Travessa Alegre, 23' },
    { nome: 'Rafael Costa', telefone: '31977889900', endereco: 'Rua das Palmeiras, 54' },
    { nome: 'Beatriz Rocha', telefone: '41999887755', endereco: 'Rua do Sol, 8' },
    { nome: 'Fernando Almeida', telefone: '51966778899', endereco: 'Rua das Acácias, 33' },
    { nome: 'Isabela Nunes', telefone: '61988997766', endereco: 'Avenida Brasil, 250' }
  ];

  cadastroForm: FormGroup = this.fb.group({
    nome: ['', [Validators.required, Validators.minLength(3)]],
    telefone: ['', Validators.required],
    endereco: ['']
  });

  submitted = false;
  erroCadastro = false;

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
      }
    });
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
      this.servicoPedido.fazerPedido().subscribe({
        next: () => this.showSuccess('Pedido finalizado com sucesso!'),
        error: () => this.showError('Falha ao finalizar o pedido.')
      });
    }
  }

  salvarOrcamento() {
    if (confirm('Deseja salvar o orçamento?')) {
      this.servicoOrcamento.fazerOrcamento().subscribe({
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
}
