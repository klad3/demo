import { Component } from '@angular/core';
import { Curso } from '../../interfaces/curso';
import { CursoService } from '../../services/curso.service';
import { CrearCursoComponent } from '../crear-curso/crear-curso.component';

@Component({
  selector: 'app-lista-cursos',
  standalone: true,
  imports: [CrearCursoComponent],
  templateUrl: './lista-cursos.component.html',
  styleUrl: './lista-cursos.component.css'
})
export class ListaCursosComponent {
  constructor(private cursoService: CursoService) {}

  cursos?: Curso[];
  curso?: Curso;

  ngOnInit(): void {
    this.getAllCursos();
  }

  getAllCursos(): void {
    this.cursoService.getCursos().subscribe(
      {
        next: (cursos: Curso[] | undefined) => {
          this.cursos = cursos;
        },
        error: (err) => {
          console.log(err)
        }
      }
    )
  }
  deleteCurso(id: number): void {
    this.cursoService.deleteCurso(id).subscribe({
      next: (response) => {
        this.getAllCursos()
      },
      error: (err) => {
        console.log(err)
      }
    })
  }

  updateCurso(id: number, curso: Curso): void {
    this.cursoService.updateCurso(id, curso).subscribe({
      next: (response) => {
        this.getAllCursos()
      },
      error: (err) => {
        console.log(err)
      }
    })
  }

  loadCurso(curso: Curso) {
    this.curso = curso;
  }
}
