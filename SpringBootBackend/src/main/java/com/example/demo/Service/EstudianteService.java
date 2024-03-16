package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Estudiante;

public interface EstudianteService {

    Estudiante guardarEstudiante(Estudiante estudiante, Long idAula);
    List<Estudiante> listarEstudiantes();
    List<Estudiante> listarEstudiantesPorAula(Long idAula);
    Estudiante obtenerEstudiante(Long id);
    Estudiante actualizarEstudiante(Long id, Estudiante estudiante);
    void eliminarEstudiante(Long id);
}
