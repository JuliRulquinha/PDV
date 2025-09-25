import { Component } from '@angular/core';
import { Produto } from '../pos/pos.component';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { selectLastProduto } from '../../store/produto.selectors';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-checkout-display',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './checkout-display.html',
  styleUrls: ['./checkout-display.css']
})
export class CheckoutDisplay {
  lastProduct$: Observable<Produto | undefined>;

  constructor(private store: Store) {
    this.lastProduct$ = this.store.select(selectLastProduto);
  }
}
