import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Curso } from '../interfaces/curso';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  constructor(private http: HttpClient) { }

  apiUrl: string = 'http://localhost:8080/api/cursos'
  curso!: Curso;

  getCursos(): Observable<Curso[] | undefined> {
    return this.http.get<Curso[]>(this.apiUrl).pipe(
      catchError( (error) => {
        console.error('Error al obtener la lista de cursos:', error);
        return of(undefined)
      })
    );
  }
  
  getCurso(id: number): Observable<Curso | undefined>{
    return this.http.get<Curso>(this.apiUrl + "/" + id).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  createCurso(curso: Curso): Observable<Curso | undefined>{
    return this.http.post<Curso>(this.apiUrl, curso).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  updateCurso(id: number, curso: Curso): Observable<Curso | undefined>{
    return this.http.put<Curso>(this.apiUrl + "/" + id, curso).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  }

  deleteCurso(id: number): Observable<any>{
    return this.http.delete(this.apiUrl + "/" + id).pipe(
      catchError( (error) => {
        return of(undefined)
      })
    )
  } 
}
