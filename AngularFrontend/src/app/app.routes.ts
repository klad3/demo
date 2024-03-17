import { Routes } from '@angular/router';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { UsuarioPageComponent } from './pages/usuario-page/usuario-page.component';

export const routes: Routes = [
    { path: 'home', component: MainPageComponent },
    { path: 'usuarios', component: UsuarioPageComponent },
    //{ path: '*', redirectTo: 'home' }
];