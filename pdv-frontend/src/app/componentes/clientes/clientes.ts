import { Component, EventEmitter, inject, Input, OnInit, Output } from '@angular/core';
import { Cliente, ServicoCliente } from '../../servicos/entities/servico-cliente';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ServicoOrcamento } from '../../servicos/entities/servico-orcamento';
import { ServicoPedido } from '../../servicos/entities/servico-pedido';
// import {
//   MatSnackBar,
//   MatSnackBarAction,
//   MatSnackBarActions,
//   MatSnackBarLabel,
//   MatSnackBarRef,
// } from '@angular/material/snack-bar';

@Component({
  selector: 'app-clientes',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './clientes.html',
  styleUrl: './clientes.css'
})
export class Clientes implements OnInit{

  ngOnInit(): void {
    this.buscarClientes();
  }

  @Input() tipoDeCriacao?: 'pedido' | 'orcamento';
  @Output() pularInputDeCliente = new EventEmitter<'pedido'| 'orcamento'>();
  

  //private _snackBar = inject(MatSnackBar);
  fb = inject(FormBuilder);
  servicoCliente = inject(ServicoCliente);
  servicoOrcamento = inject(ServicoOrcamento);
  servicoPedido = inject(ServicoPedido);
  router = inject(Router);
  
  clientes: Cliente[] = [];

  buscarClientes(){
    this.servicoCliente.buscar().subscribe(
      clientesDoDb => {
        this.clientes = clientesDoDb;
      }
    );
  }

  cadastroForm: FormGroup = this.fb.group({
    nome: ['', [Validators.required, Validators.minLength(3)]],
    telefone: ['', Validators.required],  
    endereco: ['']
  });

  submitted = false;
  erroCadastro = false;

  cadastrar(){
    this.submitted = true;

     if (this.cadastroForm.invalid) {
       this.cadastroForm.markAllAsTouched();
       return;
     }

     const cliente = this.cadastroForm.value;

     this.servicoCliente.cadastrar(cliente).subscribe({
      next: (resposta) => {
        console.log("Cliente cadastrado: " + resposta)
        this.erroCadastro = false; 
        
      },
      error: (erro) => {
        
        if (erro.status === 403) {
          this.erroCadastro = true; 
        } else {
          alert('Ocorreu um erro inesperado. Tente novamente.');
        }
      }
     });
  }

  pular(){
    this.pularInputDeCliente.emit(this.tipoDeCriacao);
  }

  confirmar(){
    if(this.tipoDeCriacao === "orcamento"){
      return this.salvarOrcamento();
    }

    if(this.tipoDeCriacao === "pedido"){
      return this.salvarPedido();
    }
    
  }

  

  salvarPedido() {
    if(confirm("Deseja finalizar a compra?")){
      this.servicoPedido.fazerPedido().subscribe();
    }
  }

  salvarOrcamento(){
    if(confirm("Deseja salvar o orçamento?")){
      this.servicoOrcamento.fazerOrcamento().subscribe();
    }
  }
}
