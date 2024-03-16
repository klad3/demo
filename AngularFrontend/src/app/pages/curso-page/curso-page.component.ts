import { Component } from '@angular/core';
import { ListaCursosComponent } from '../../components/lista-cursos/lista-cursos.component';

@Component({
  selector: 'app-curso-page',
  standalone: true,
  imports: [ListaCursosComponent],
  templateUrl: './curso-page.component.html',
  styleUrl: './curso-page.component.css'
})
export class CursoPageComponent {

}
