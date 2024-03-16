import { Component } from '@angular/core';
import { ListaUsuariosComponent } from '../../components/lista-usuarios/lista-usuarios.component';
import { CrearUsuarioComponent } from '../../components/crear-usuario/crear-usuario.component';

@Component({
  selector: 'app-usuario-page',
  standalone: true,
  imports: [CrearUsuarioComponent, ListaUsuariosComponent],
  templateUrl: './usuario-page.component.html',
  styleUrl: './usuario-page.component.css'
})
export class UsuarioPageComponent {

}
