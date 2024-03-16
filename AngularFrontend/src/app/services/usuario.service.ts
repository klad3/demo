import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Usuario } from '../interfaces/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  apiUrl: string = 'http://localhost:8080/api/usuarios'
  public usuario!: Usuario;

  getUsuarios(): Observable<Usuario[] | undefined> {
    return this.http.get<Usuario[]>(this.apiUrl).pipe(
      
      catchError( (error) => {
        console.error('Error al obtener la lista de usuarios:', error);
        return of(undefined)
      })
    );
  }
  
  getUsuario(id: number): Observable<Usuario | undefined>{
    return this.http.get<Usuario>(this.apiUrl + "/" + id).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  createUsuario(usuario: Usuario): Observable<Usuario | undefined>{
    return this.http.post<Usuario>(this.apiUrl, usuario).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  updateUsuario(id: number, usuario: Usuario): Observable<Usuario | undefined>{
    return this.http.put<Usuario>(this.apiUrl + "/" + id, usuario).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  deleteUsuario(id: number): Observable<any>{
    return this.http.delete(this.apiUrl + "/" + id).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  } 
}
