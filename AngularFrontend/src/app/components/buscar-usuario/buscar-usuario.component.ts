import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from '../../interfaces/usuario';

@Component({
  selector: 'app-buscar-usuario',
  standalone: true,
  imports: [],
  templateUrl: './buscar-usuario.component.html',
  styleUrl: './buscar-usuario.component.css'
})
export class BuscarUsuarioComponent implements OnInit{
  
  constructor(private servicioUsuario: UsuarioService) {}

  usuarios?: Usuario[];

  ngOnInit(): void {
    this.servicioUsuario.getUsuarios().subscribe(
      {
        next: (usuarios: Usuario[] | undefined) => {
          this.usuarios = usuarios;
          console.log(this.usuarios)
        },
        error: (err) => {
          console.log(err)
        } 
      }
    )
      throw new Error("Metodo no implementado");
  }
}
