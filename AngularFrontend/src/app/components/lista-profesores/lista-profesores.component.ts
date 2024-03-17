import { Component } from '@angular/core';
import { Profesor } from '../../interfaces/profesor';
import { ProfesorService } from '../../services/profesor.service';
import { CrearProfesorComponent } from '../crear-profesor/crear-profesor.component';

@Component({
  selector: 'app-lista-profesores',
  standalone: true,
  imports: [CrearProfesorComponent],
  templateUrl: './lista-profesores.component.html',
  styleUrl: './lista-profesores.component.css'
})
export class ListaProfesoresComponent {
  constructor(private profesorService: ProfesorService) {}

  profesores?: Profesor[];
  profesor?: Profesor;

  ngOnInit(): void {
    this.getAllProfesores();
  }

  getAllProfesores(): void {
    this.profesorService.getProfesores().subscribe(
      {
        next: (profesors: Profesor[] | undefined) => {
          this.profesores = profesors;
        },
        error: (err) => {
          console.log(err)
        }
      }
    )
  }
  deleteProfesor(id: number): void {
    this.profesorService.deleteProfesor(id).subscribe({
      next: (response) => {
        this.getAllProfesores()
      },
      error: (err) => {
        console.log(err)
      }
    })
  }

  updateProfesor(id: number, profesor: Profesor): void {
    this.profesorService.updateProfesor(id, profesor).subscribe({
      next: (response) => {
        this.getAllProfesores()
      },
      error: (err) => {
        console.log(err)
      }
    })
  }

  loadProfesor(profesor: Profesor) {
    this.profesor = profesor;
  }
}
