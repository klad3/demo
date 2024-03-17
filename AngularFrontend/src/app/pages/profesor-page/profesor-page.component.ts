import { Component } from '@angular/core';
import { ListaProfesoresComponent } from '../../components/lista-profesores/lista-profesores.component';

@Component({
  selector: 'app-profesor-page',
  standalone: true,
  imports: [ListaProfesoresComponent],
  templateUrl: './profesor-page.component.html',
  styleUrl: './profesor-page.component.css'
})
export class ProfesorPageComponent {

}
