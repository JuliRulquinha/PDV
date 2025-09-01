import { Component, inject } from '@angular/core';
import { FormsModule, ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-pagina-de-login',
  imports: [FormsModule, 
            MatButtonModule, 
            MatFormFieldModule, 
            MatInputModule, 
            ReactiveFormsModule, 
            MatCardModule, 
            MatButtonModule,
            MatGridListModule, 
            MatIconModule],
  templateUrl: './pagina-de-login.html',
  styleUrl: './pagina-de-login.css'
})
export class PaginaDeLogin {
showPassword = false;
fb = inject(FormBuilder);

  form = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(3)]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    remember: [false]
  });

  

  onSubmit() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    // Replace with real authentication logic
    console.log('Login submitted', this.form.value);
    alert(`Logged in as: ${this.form.value.username}`);
  }

  toggleShowPassword() {
    this.showPassword = !this.showPassword;
  }
}
