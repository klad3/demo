package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Curso;

public interface CursoService {

    Curso crearCurso(Curso curso);
    List<Curso> listarTodosLosCursos();
    Curso obtenerCursoPorId(Long id);
    Curso actualizarCurso(Long id, Curso curso);
    void eliminarCurso(Long id);
}
