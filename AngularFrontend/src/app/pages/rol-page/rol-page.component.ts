import { Component } from '@angular/core';
import { ListaRolsComponent } from '../../components/lista-roles/lista-roles.component';

@Component({
  selector: 'app-rol-page',
  standalone: true,
  imports: [ListaRolsComponent],
  templateUrl: './rol-page.component.html',
  styleUrl: './rol-page.component.css'
})
export class RolPageComponent {

}
