import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { Profesor } from '../../interfaces/profesor';
import { ProfesorService } from '../../services/profesor.service';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-crear-profesor',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './crear-profesor.component.html',
  styleUrl: './crear-profesor.component.css'
})
export class CrearProfesorComponent implements OnChanges{
  profesorForm: FormGroup;
  @Input() profesorSeleccionado?: Profesor;
  @Output() actualizarLista = new EventEmitter<any>();

  constructor(private fb: FormBuilder, private profesorService: ProfesorService) {
    this.profesorForm = this.fb.group({
      correo: new FormControl('', [Validators.required]),
      idUsuario: new FormControl('', [Validators.required]),
    })
  }

  ngOnChanges(): void {
      if (this.profesorSeleccionado) {
        this.profesorForm.patchValue({
          correo: this.profesorSeleccionado?.correo,
          idUsuario: this.profesorSeleccionado?.usuario.idUsuario
        })
      }
  }

  onSubmit() {
    if (this.profesorForm.valid) {
      if (this.profesorSeleccionado) {
        this.profesorService.updateProfesor(this.profesorSeleccionado.idProfesor, this.profesorForm.value).subscribe({
          next:(response) => {     
            this.profesorForm.reset();
            this.actualizarLista.emit();
          },
          error: (err) => {
            console.log(err)
          } 
        })
      } else {
        this.profesorService.createProfesor(this.profesorForm.value).subscribe({
          next:(response) => {
            this.profesorForm.reset();
            this.actualizarLista.emit();
          },
          error: (err) => {
            console.log(err)
          } 
        })
      }
      
    } else {
      this.profesorForm.markAllAsTouched();
    }
  }
}
