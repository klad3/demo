package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Curso;

public interface CursoService {

    Curso guardarCurso(Curso curso);

    List<Curso> listarCursos();

    Curso obtenerCurso(Long id);

    Curso actualizarCurso(Long id, Curso curso);
    
    void eliminarCurso(Long id);
}
