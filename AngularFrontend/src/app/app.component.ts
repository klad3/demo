import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UsuarioPageComponent } from './pages/usuario-page/usuario-page.component';
import { MainPageComponent } from './pages/main-page/main-page.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, UsuarioPageComponent, MainPageComponent],
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
