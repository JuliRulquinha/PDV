import { Component, Input } from '@angular/core';
import { Produto } from '../pos/pos.component';

@Component({
  selector: 'app-checkout-display',
  imports: [],
  templateUrl: './checkout-display.html',
  styleUrl: './checkout-display.css'
})
export class CheckoutDisplay {
 @Input() lastProduct?: Produto;
}
