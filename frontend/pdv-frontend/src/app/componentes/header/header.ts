import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  imports: [MatToolbarModule,
            MatButtonModule, 
            MatIconModule, 
            MatButtonToggleModule, 
            MatMenuModule,
            RouterLink],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {

}
