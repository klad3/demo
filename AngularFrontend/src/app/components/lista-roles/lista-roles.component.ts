import { Component } from '@angular/core';
import { Rol } from '../../interfaces/rol';
import { RolService } from '../../services/rol.service';
import { CrearRolComponent } from '../crear-rol/crear-rol.component';

@Component({
  selector: 'app-lista-roles',
  standalone: true,
  imports: [CrearRolComponent],
  templateUrl: './lista-roles.component.html',
  styleUrl: './lista-roles.component.css'
})
export class ListaRolsComponent {
  constructor(private rolService: RolService) {}

  roles?: Rol[];
  rol?: Rol;

  ngOnInit(): void {
    this.getAllRoles();
  }

  getAllRoles(): void {
    this.rolService.getRoles().subscribe(
      {
        next: (roles: Rol[] | undefined) => {
          this.roles = roles;
        },
        error: (err) => {
          console.log(err)
        }
      }
    )
  }
  deleteRol(id: number): void {
    this.rolService.deleteRol(id).subscribe({
      next: (response) => {
        this.getAllRoles()
      },
      error: (err) => {
        console.log(err)
      }
    })
  }

  updateRol(id: number, rol: Rol): void {
    this.rolService.updateRol(id, rol).subscribe({
      next: (response) => {
        this.getAllRoles()
      },
      error: (err) => {
        console.log(err)
      }
    })
  }

  loadRol(rol: Rol) {
    this.rol = rol;
  }
}
