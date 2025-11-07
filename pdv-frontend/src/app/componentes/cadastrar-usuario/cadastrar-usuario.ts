import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Papel, ServicoAutenticacao, VerUsuario } from '../../servicos/auth/servico-autenticacao';
import { ServicoUsuario } from '../../servicos/auth/servico-usuario';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cadastrar-usuario',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './cadastrar-usuario.html',
  styleUrl: './cadastrar-usuario.css'
})
export class CadastrarUsuario {

  fb = inject(FormBuilder);
  //authService = inject(ServicoAutenticacao);
  servicoUsuario = inject(ServicoUsuario);
  router = inject(Router);

  cadastroForm: FormGroup = this.fb.group({
    nome: ['', Validators.required],
    papel: ['', Validators.required],  
    senha: ['', Validators.required]
  });


  papeis = [
  { label: 'Selecione uma função', value: '' },
  { label: 'Administrador', value: Papel.ADMIN },
  { label: 'Usuário', value: Papel.USUARIO },
  { label: 'Gerente', value: Papel.GERENTE },
];

  submitted = false;
  erroCadastro = false;

  cadastrar(){
    this.submitted = true;

     if (this.cadastroForm.invalid) {
       this.cadastroForm.markAllAsTouched();
       return;
     }

     const usuario = this.cadastroForm.value;

     this.servicoUsuario.cadastrar(usuario).subscribe({
      next: (resposta) => {
        console.log("Usuário cadastrado: " + resposta)
        this.erroCadastro = false; 
        this.router.navigate(['/checkout']);
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
}
