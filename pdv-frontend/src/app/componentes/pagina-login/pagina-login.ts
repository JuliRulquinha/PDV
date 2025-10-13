import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ServicoAutenticacao } from '../../servicos/auth/servico-autenticacao';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pagina-login',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './pagina-login.html',
  styleUrl: './pagina-login.css'
})
export class PaginaLogin {

  fb = inject(FormBuilder);
  authService = inject(ServicoAutenticacao);
  router = inject(Router);

  loginForm: FormGroup = this.fb.group({
    nome: ['', Validators.required],  
    senha: ['', Validators.required]
  });

  submitted = false;
  erroLogin = false;

  login() {
    this.submitted = true;

    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
      return;
    }

    const usuario = this.loginForm.value;

    this.authService.autenticar(usuario).subscribe({
      next: (resposta) => {
        this.authService.salvarToken(resposta.token);
        this.erroLogin = false; // limpa o erro se o login deu certo
        this.router.navigate(['/checkout']);
      },
      error: (erro) => {
        console.error('Erro no login:', erro);
        if (erro.status === 403) {
          this.erroLogin = true; // mostra "credenciais inválidas"
        } else {
          alert('Ocorreu um erro inesperado. Tente novamente.');
        }
      }
    });
  }
}
