import { Component, inject, Output } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { BrowserModule } from '@angular/platform-browser';
import { ServicoProduto } from '../../servicos/servico-produto';
import { Produto } from '../mostruario/mostruario';


@Component({
  selector: 'app-barra-pesquisa',
  imports: [ 
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule],
  templateUrl: './barra-pesquisa.html',
  styleUrl: './barra-pesquisa.css'
})
export class BarraPesquisa {

  @Output() produto!:Produto;

  servicoDeProduto = inject(ServicoProduto);

  onSearch(id: any){
    this.servicoDeProduto.tragaProduto(Number(id)).subscribe( data => {
      this.produto = data;
      console.log(data);
    });
  }
}
