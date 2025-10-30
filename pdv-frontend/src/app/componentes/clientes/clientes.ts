import { Component, EventEmitter, inject, OnInit, Output } from '@angular/core';
import { Cliente, ServicoCliente } from '../../servicos/entities/servico-cliente';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

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

  @Output() pularInputDeCliente = new EventEmitter();
  @Output() confirmarCompra = new EventEmitter();

  fb = inject(FormBuilder);
  servicoCliente = inject(ServicoCliente);
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

  // papeis = [
  //   { label: 'Selecione um papel', value: '' },
  //   { label: 'Administrador', value: Papel.ADMIN },
  //   { label: 'Usuário', value: Papel.cliente },
  //   { label: 'Gerente', value: Papel.GERENTE }
  // ];

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
        this.confirmarCompra.emit();
        
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
    this.pularInputDeCliente.emit();
    this.confirmarCompra.emit();
  }
}
