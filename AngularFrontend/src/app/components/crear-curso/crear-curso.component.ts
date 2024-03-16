import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { Curso } from '../../interfaces/curso';
import { CursoService } from '../../services/curso.service';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-crear-curso',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './crear-curso.component.html',
  styleUrl: './crear-curso.component.css'
})
export class CrearCursoComponent implements OnChanges{
  cursoForm: FormGroup;
  @Input() cursoSeleccionado?: Curso;
  @Output() actualizarLista = new EventEmitter<any>();

  constructor(private fb: FormBuilder, private cursoService: CursoService) {
    this.cursoForm = this.fb.group({
      nombreCurso: new FormControl('', [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
      cantidadHoras: new FormControl('', [Validators.required])
    })
  }

  ngOnChanges(): void {
      if (this.cursoSeleccionado) {
        this.cursoForm.patchValue({
          nombreCurso: this.cursoSeleccionado?.nombreCurso,
          descripcion: this.cursoSeleccionado?.descripcion,
          cantidadHoras: this.cursoSeleccionado?.cantidadHoras,
        })
      }
  }

  onSubmit() {
    if (this.cursoForm.valid) {
      if (this.cursoSeleccionado) {
        this.cursoService.updateCurso(this.cursoSeleccionado.idCurso, this.cursoForm.value).subscribe({
          next:(response) => {     
            this.cursoForm.reset();
            this.actualizarLista.emit();
          },
          error: (err) => {
            console.log(err)
          } 
        })
      } else {
        this.cursoService.createCurso(this.cursoForm.value).subscribe({
          next:(response) => {
            this.cursoForm.reset();
            this.actualizarLista.emit();
          },
          error: (err) => {
            console.log(err)
          } 
        })
      }
      
    } else {
      this.cursoForm.markAllAsTouched();
    }
  }
}
