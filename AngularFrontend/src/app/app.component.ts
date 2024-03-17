import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UsuarioPageComponent } from './pages/usuario-page/usuario-page.component';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { RolPageComponent } from './pages/rol-page/rol-page.component';
import { CursoPageComponent } from './pages/curso-page/curso-page.component';
import { ProfesorPageComponent } from './pages/profesor-page/profesor-page.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, UsuarioPageComponent, MainPageComponent, RolPageComponent, CursoPageComponent, ProfesorPageComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Crud de Entidades de Colegio';
  ind: number = 0;
  cambiarEstado(ind: number): void {
    this.ind = ind;
  }
}
