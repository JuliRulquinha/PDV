
import { CommonModule, DecimalPipe } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule, DecimalPipe],
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  @Input() products: Array<{ code: string; name: string; price: number; quantity: number }> = [];
}
