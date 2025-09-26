import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-pagina-login',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './pagina-login.html',
  styleUrl: './pagina-login.css'
})
export class PaginaLogin {
  loginForm: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {
    // Criar o form group com validações
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  login() {

    this.submitted = true;

    if (this.loginForm.invalid) {
      return; // impede envio se o formulário for inválido
    }

    if (this.loginForm.valid) {
      console.log('Form Value:', this.loginForm.value);
      // Chamar serviço de autenticação aqui
    } else {
      console.log('Form inválido');
      this.loginForm.markAllAsTouched();
    }
  }
}
