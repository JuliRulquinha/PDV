import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggle, MatButtonToggleGroup } from '@angular/material/button-toggle';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-barra-de-pesquisa',
  imports: [MatFormFieldModule, MatIconModule, MatButtonModule, ReactiveFormsModule, FormsModule, MatInputModule, MatButtonToggle],
  templateUrl: './barra-de-pesquisa.html',
  styleUrl: './barra-de-pesquisa.css'
})
export class BarraDePesquisa {

  barraDePesquisaAtivada = false;

  ativarBarraDePesquisa(){
    this.barraDePesquisaAtivada = !this.barraDePesquisaAtivada
  }
}
