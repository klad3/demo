import { Component, EventEmitter, Output } from '@angular/core';
import { Usuario } from '../../interfaces/usuario';
import { UsuarioService } from '../../services/usuario.service';
import { CrearUsuarioComponent } from '../crear-usuario/crear-usuario.component';

@Component({
  selector: 'app-lista-usuarios',
  standalone: true,
  imports: [CrearUsuarioComponent],
  templateUrl: './lista-usuarios.component.html',
  styleUrl: './lista-usuarios.component.css'
})
export class ListaUsuariosComponent {
  constructor(private usuarioService: UsuarioService) {}

  usuarios?: Usuario[];
  usuario?: Usuario;

  ngOnInit(): void {
    this.getAllUsuarios();
  }

  getAllUsuarios(): void {
    this.usuarioService.getUsuarios().subscribe(
      {
        next: (usuarios: Usuario[] | undefined) => {
          this.usuarios = usuarios;
        },
        error: (err) => {
          console.log(err)
        }
      }
    )
      throw new Error("Metodo no implementado");
  }
  deleteUsuario(id: number): void {
    this.usuarioService.deleteUsuario(id).subscribe({
      next: (response) => {
        this.getAllUsuarios()
      },
      error: (err) => {
        console.log(err)
      }
    })
  }

  updateUsuario(id: number, usuario: Usuario): void {
    this.usuarioService.updateUsuario(id, usuario).subscribe({
      next: (response) => {
        this.getAllUsuarios()
      },
      error: (err) => {
        console.log(err)
      }
    })
  }

  loadUsuario(usuario: Usuario) {
    this.usuario = usuario;
  }
}
