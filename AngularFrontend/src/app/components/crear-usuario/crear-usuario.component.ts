import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Usuario } from '../../interfaces/usuario';
import { UsuarioService } from '../../services/usuario.service';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-crear-usuario',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './crear-usuario.component.html',
  styleUrl: './crear-usuario.component.css'
})
export class CrearUsuarioComponent implements OnChanges{
  usuarioForm: FormGroup;
  @Input() usuarioSeleccionado?: Usuario;

  constructor(private fb: FormBuilder, private usuarioService: UsuarioService) {
    this.usuarioForm = this.fb.group({
      nombres: new FormControl('', [Validators.required]),
      apellidos: new FormControl('', [Validators.required]),
      contrasenia: new FormControl('', [Validators.required]),
    })
  }

  ngOnChanges(): void {
      if (this.usuarioSeleccionado) {
        this.usuarioForm.patchValue({
          nombres: this.usuarioSeleccionado?.nombres,
          apellidos: this.usuarioSeleccionado?.apellidos,
          contrasenia: this.usuarioSeleccionado?.contrasenia,
        })
      }
  }

  onSubmit() {
    if(this.usuarioForm.valid) {
      if (this.usuarioSeleccionado) {
        this.usuarioService.updateUsuario(this.usuarioSeleccionado.idUsuario, this.usuarioForm.value).subscribe({
          next:(response) => {
            this.usuarioForm.reset
          },
          error: (err) => {
            console.log(err)
          } 
        })
      } else {
        this.usuarioService.createUsuario(this.usuarioForm.value).subscribe({
          next:(response) => {
            this.usuarioForm.reset
          },
          error: (err) => {
            console.log(err)
          } 
        })
      }
      
    } else {
      this.usuarioForm.markAllAsTouched();
    }
  }
}
