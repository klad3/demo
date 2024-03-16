import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Rol } from '../interfaces/rol';

@Injectable({
  providedIn: 'root'
})
export class RolService {

  constructor(private http: HttpClient) { }

  apiUrl: string = 'http://localhost:8080/api/roles'
  rol!: Rol;

  getRoles(): Observable<Rol[] | undefined> {
    return this.http.get<Rol[]>(this.apiUrl).pipe(
      
      catchError( (error) => {
        console.error('Error al obtener la lista de Roles:', error);
        return of(undefined)
      })
    );
  }
  
  getRol(id: number): Observable<Rol | undefined>{
    return this.http.get<Rol>(this.apiUrl + "/" + id).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  createRol(rol: Rol): Observable<Rol | undefined>{
    return this.http.post<Rol>(this.apiUrl, rol).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  updateRol(id: number, rol: Rol): Observable<Rol | undefined>{
    return this.http.put<Rol>(this.apiUrl + "/" + id, rol).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  deleteRol(id: number): Observable<any>{
    return this.http.delete(this.apiUrl + "/" + id).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  } 
}
