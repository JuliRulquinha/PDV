import { Component, inject, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ServicoProduto } from './servicos/servico-produto';
import { BarraPesquisa } from './componentes/barra-pesquisa/barra-pesquisa';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, BarraPesquisa],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit{

  ngOnInit(): void {
    var produto = this.servicoDeProduto.tragaProduto(1);
    produto.subscribe(data => {
      console.log(data);
    })
  }
  servicoDeProduto = inject(ServicoProduto);

  
}
