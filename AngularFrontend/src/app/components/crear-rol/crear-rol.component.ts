import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { Rol } from '../../interfaces/rol';
import { RolService } from '../../services/rol.service';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-crear-rol',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './crear-rol.component.html',
  styleUrl: './crear-rol.component.css'
})
export class CrearRolComponent implements OnChanges{
  rolForm: FormGroup;
  @Input() rolSeleccionado?: Rol;
  @Output() actualizarLista = new EventEmitter<any>();

  constructor(private fb: FormBuilder, private rolService: RolService) {
    this.rolForm = this.fb.group({
      nombre: new FormControl('', [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
    })
  }

  ngOnChanges(): void {
      if (this.rolSeleccionado) {
        this.rolForm.patchValue({
          nombre: this.rolSeleccionado?.nombre,
          descripcion: this.rolSeleccionado?.descripcion,
        })
      }
  }

  onSubmit() {
    if (this.rolForm.valid) {
      if (this.rolSeleccionado) {
        this.rolService.updateRol(this.rolSeleccionado.idRol, this.rolForm.value).subscribe({
          next:(response) => {     
            this.rolForm.reset();
            this.actualizarLista.emit();
          },
          error: (err) => {
            console.log(err)
          } 
        })
      } else {
        this.rolService.createRol(this.rolForm.value).subscribe({
          next:(response) => {
            this.rolForm.reset();
            this.actualizarLista.emit();
          },
          error: (err) => {
            console.log(err)
          } 
        })
      }
      
    } else {
      this.rolForm.markAllAsTouched();
    }
  }
}
