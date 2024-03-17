import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Profesor } from '../interfaces/profesor';

@Injectable({
  providedIn: 'root'
})
export class ProfesorService {

  constructor(private http: HttpClient) { }

  apiUrl: string = 'http://localhost:8080/api/profesores'
  profesor!: Profesor;

  getProfesores(): Observable<Profesor[] | undefined> {
    return this.http.get<Profesor[]>(this.apiUrl).pipe(
      catchError( (error) => {
        console.error('Error al obtener la lista de profesors:', error);
        return of(undefined)
      })
    );
  }
  
  getProfesor(id: number): Observable<Profesor | undefined>{
    return this.http.get<Profesor>(this.apiUrl + "/" + id).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  createProfesor(profesor: Profesor): Observable<Profesor | undefined>{
    return this.http.post<Profesor>(this.apiUrl, profesor).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  updateProfesor(id: number, profesor: Profesor): Observable<Profesor | undefined>{
    return this.http.put<Profesor>(this.apiUrl + "/" + id, profesor).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  deleteProfesor(id: number): Observable<any>{
    return this.http.delete(this.apiUrl + "/" + id).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  } 
}
